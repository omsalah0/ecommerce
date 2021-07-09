package com.eMusicStore.controller;


import com.eMusicStore.Exceptions.ProductNotFound;
import com.eMusicStore.Services.productService;
import com.eMusicStore.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final productService productService;
    private Path path;

    @Autowired
    public AdminController(productService productDAO) {
        this.productService = productDAO;
    }

    @InitBinder
    public void stringTo(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping
    public String GetAdmin() {
        return "Admin";
    }

    @GetMapping("/productInventory")
    public String getInventory(Model model) {
        List<Product> list = productService.getAllProducts();
        model.addAttribute("products", list);
        return "productInventory";
    }

    @GetMapping("/productInventory/addProduct")
    public String getForm(Model model) {
        //if you need pass default value to form make set method and pass the value on it.
        Product product = new Product();
        model.addAttribute("product", product);
        return "addProduct";
    }

    @PostMapping("/productInventory/addProduct")
    public String processForm(@Valid @ModelAttribute Product product,
                              BindingResult bindingResult,
                              @RequestParam("file") MultipartFile file,
                              HttpServletRequest request, Model model) {
        String typeUploadedFile = file.getContentType();
        if (bindingResult.hasErrors()) {
            return "addProduct";
        } else if (file.isEmpty()) {
            model.addAttribute("errorFile", "This field is Required");
            return "addProduct";
        } else if (!typeUploadedFile.substring(0, 5).equals("image")) {
            model.addAttribute("errorFile", "Only images will considered");
            return "addProduct";
        }


        productService.addOrUpdateProduct(product);

        String rootDir = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDir + "\\WEB-INF\\resources\\images\\" + product.getProductID() + ".png");

        try {
            file.transferTo(new File(path.toString()));
        } catch (Exception e) {
            throw new RuntimeException("failed to upload image because " + e.getMessage());
        }


        return "redirect:/admin/productInventory";
    }

    @GetMapping("/productInventory/delete/{deleteId}")
    public String deleteWithID(@PathVariable String deleteId, Model model, HttpServletRequest request) {
        if (productService.getProductById(deleteId) == null) {
            throw new ProductNotFound("Not Found Product ID");
        }

        productService.deleteProduct(deleteId);
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDir + "\\WEB-INF\\resources\\images\\" + deleteId + ".png");
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return "redirect:/admin/productInventory";
    }

    @GetMapping("/update/updateProduct/{id}")
    public String updateProduct(Model model, @PathVariable String id) {
        Product product = productService.getProductById(id);
        model.addAttribute(product);

        return "editProduct";
    }

    @PostMapping("/update/updateProduct")
    public String updateProductProcess(@Valid @ModelAttribute("product") Product product,
                                       BindingResult bindingResult,
                                       @RequestParam("file") MultipartFile file,
                                       HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "editProduct";
        }
        productService.addOrUpdateProduct(product);
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDir + "\\WEB-INF\\resources\\images\\" + product.getProductID() + ".png");
        if (file != null && !file.isEmpty()) {
            try {
                file.transferTo(new File(path.toString()));
            } catch (Exception e) {
                throw new RuntimeException("Failed to upload image");
            }
        }


        return "redirect:/admin/productInventory";
    }

}

