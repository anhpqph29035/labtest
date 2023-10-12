package com.example.lab2.controller;

import com.example.lab2.model.Phong;
import com.example.lab2.service.LoaiPhongService;
import com.example.lab2.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/phong")
public class PhongController {
    @Autowired
    PhongService ps;
    @Autowired
    LoaiPhongService lps;
    @GetMapping("/hien-thi")
    public String show(Model model, @RequestParam(value = "page",defaultValue = "0") int page){
        Page<Phong> phong=ps.getList(page);
        model.addAttribute("LIST",phong);
        model.addAttribute("s",new Phong());
        model.addAttribute("LISTLOAI",lps.getList());
        return "index";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("s") Phong p,
                      Model model, @RequestParam(value = "page",defaultValue = "0") int page){
        ps.add(p);
        model.addAttribute("ThongBao","Thêm thành công");
        model.addAttribute("s",new Phong());
        model.addAttribute("LISTLOAI",lps.getList());
        Page<Phong> phong=ps.getList(page);
        model.addAttribute("LIST",phong);
        return "index";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id,
                         Model model){

        model.addAttribute("LISTLOAI",lps.getList());
        Page<Phong> phong=ps.getList(0);
        model.addAttribute("LIST",phong);
        model.addAttribute("s",ps.getPhong(UUID.fromString(id)));
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id,
                         Model model){
        ps.delete(UUID.fromString(id));
        model.addAttribute("s",new Phong());
        model.addAttribute("LISTLOAI",lps.getList());
        Page<Phong> phong=ps.getList(0);
        model.addAttribute("LIST",phong);
        return "index";
    }
}
