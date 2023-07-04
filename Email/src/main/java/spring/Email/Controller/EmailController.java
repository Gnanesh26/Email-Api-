package spring.Email.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.Email.Model.EmailRequest;
import spring.Email.Service.EmailService;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;


    @PostMapping("/sendmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        boolean result = emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());

        if (result) {
            return ResponseEntity.ok("Email sent successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email.");
        }
    }
}



