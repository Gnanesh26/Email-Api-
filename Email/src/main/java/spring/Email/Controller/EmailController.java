package spring.Email.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.Email.Model.EmailRequest;
import spring.Email.Service.EmailService;

@RestController
public class EmailController {


    @Autowired
    EmailService emailService;
    //api to send email
    @RequestMapping(value="/sendmail",method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
    {
        System.out.println(request);
        boolean result =  this.emailService.sendEmail(request.getSubject(),request.getMessage(), request.getTo());

        if(result){
            return ResponseEntity.ok("Email sent successfully ..!");

        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent .?" );
        }
    }

}
