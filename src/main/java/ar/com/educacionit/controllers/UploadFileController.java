package ar.com.educacionit.controllers;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Controller
public class UploadFileController {

    private final String UPLOAD_DIR = "src//main//resources//static//uploads//";
    Logger logger = (Logger) LoggerFactory.getLogger(UploadFileController.class);

    @GetMapping("/")
    public String homepage() {
        return "home";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model, RedirectAttributes attributes) {

        if (Objects.isNull(file) || file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }

        if (!this.validar(file)) {
            model.addAttribute("error", "Please select a file with extension .txt o .csv");
            return "redirect:/";
        }

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("success", "File successfully uploaded");
        logger.info("File upload Name: " + file.getOriginalFilename() + "  Size: " + file.getSize() + " bytes");
        return "redirect:/";


    }

    public boolean validar(MultipartFile file) {
        String name = file.getOriginalFilename();
        String[] arrayName = name.split("\\.");
        String ext = arrayName[arrayName.length - 1];
        return ext.equalsIgnoreCase("csv") || ext.equalsIgnoreCase("txt");
    }
}
