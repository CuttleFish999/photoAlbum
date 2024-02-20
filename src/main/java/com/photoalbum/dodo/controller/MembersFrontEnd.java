package com.photoalbum.dodo.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.photoalbum.dodo.model.Members;
import com.photoalbum.dodo.model.Photos;
import com.photoalbum.dodo.service.Impl.MembersFrontEndServiceImpl;
import com.photoalbum.dodo.service.Impl.PhotosFrontEndServiceImpl;
import jakarta.servlet.http.HttpSession;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


@Controller
@RequestMapping("")
public class MembersFrontEnd {
    @Autowired
    private MembersFrontEndServiceImpl MembersFrontEndServiceImpl;

    @Autowired
    private PhotosFrontEndServiceImpl photosFrontEndServiceImpl;


    @GetMapping("/test")
    public String test(Model model) {
        return "/frontEnd/viewport/uploadPhoto";
    }


    @GetMapping("/home")
    public String index(Model model) {

//        membersServiceImpl.getAllMembers();

        return "frontEnd/index";
    }

    @GetMapping("/login")
    public String memberLogin() {

        return "frontEnd/login";
    }

    @GetMapping("/register")
    public String memberRegister() {

        return "frontEnd/register";
    }

    //    @ResponseBody
    @PostMapping("/loginAPI")
    public String MemberLogin(@ModelAttribute Members Member,
                              HttpSession session) {
//    public String memberLoginAPI(@RequestBody Members Member){
        System.out.println(Member);
        Members member = MembersFrontEndServiceImpl.findIdByAccountAndPassword(Member);
        System.out.println(member != null);
        if (member != null) {
            session.setAttribute("loggedInMember", member);
            System.out.println("sessionMemId: " + member.getMemberid());
            return "redirect:/home";
        }
        return "redirect:/login";
    }

    @GetMapping("/signOutAPI")
    public String SignOut(HttpSession session) {
        session.invalidate();

        return "redirect:frontEnd/index";
    }

    @ResponseBody
    @PostMapping("/insert/{MemberId}")
    public Members memberRegister(@RequestBody Members Member) {

        Members memeber = MembersFrontEndServiceImpl.createAnAccount(Member);

        return memeber;
    }

//  viewportAPI

    @GetMapping("/viewport")
    public String viewportHome(Model model, HttpSession session,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "2") int size) {
        Members member = (Members) session.getAttribute("loggedInMember");
        System.out.println(member);

        Pageable pageable = PageRequest.of(page, size);
        Page<Photos> photosPage = photosFrontEndServiceImpl.getAllPhotos(pageable);

        Map<Integer, String> imageMap = new HashMap<>();
        for (Photos photo : photosPage.getContent()) {
            byte[] imageBytes = photo.getFilepath(); // Assuming getFilepath() returns image bytes
            if (imageBytes != null) {
                String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
                imageMap.put(photo.getPhotoid(), imageBase64); // Assuming getPhotoid() returns the photo's ID
            }
        }

        model.addAttribute("photos", photosPage.getContent());
        model.addAttribute("images", imageMap);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", photosPage.getTotalPages());

        return "/frontEnd/viewport/viewindex";
    }



    @PostMapping("/insertPhoto/")
    public ResponseEntity<?> insertPhotoAPI(@RequestBody String photoDataJSON, HttpSession session) {
        Members loggedInMember = (Members) session.getAttribute("loggedInMember");
        if (loggedInMember == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用户未登录");
        }

        try {
            // 使用 Jackson ObjectMapper 將 JSON 字符串轉換為 Map
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> photoData = objectMapper.readValue(photoDataJSON, new TypeReference<Map<String, String>>() {});

            // 從 Map 中獲取 Base64 編碼的圖片數據
            String base64Image = photoData.get("file");
            base64Image = base64Image.substring(base64Image.indexOf(",") + 1); // 去除Base64前綴

            // 解碼 Base64 字符串獲取二進制數據
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

            // 生成縮圖
            byte[] thumbnailBytes = createThumbnail(imageBytes);

            // 使用解析後的數據創建 Photos 對象
            Photos photo = new Photos();
            photo.setMemberid(loggedInMember.getMemberid());
            photo.setTitle(photoData.get("title"));
            photo.setDescription(photoData.get("description"));
            photo.setFilepath(imageBytes); // 原圖二進制數據
            photo.setThumbnailpath(thumbnailBytes); // 縮圖二進制數據

            // 調用 service 方法保存 photo 對象
            photosFrontEndServiceImpl.InsertPhoto(photo);

            return ResponseEntity.ok("圖片上傳成功");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("圖片上傳失敗");
        }
    }



    @GetMapping("/upLoadDate")
    public String upLoadDate(Model model) {

        return "/frontEnd/viewport/uploadPhoto";
    }

    public byte[] createThumbnail(byte[] imageBytes) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // 設置縮圖大小和質量
        Thumbnails.of(inputStream)
                .size(200, 200) // 這裡的尺寸可以根據需要調整
                .outputQuality(0.8) // 輸出的圖片質量，範圍是0.0至1.0
                .toOutputStream(outputStream);

        return outputStream.toByteArray();
    }
}
