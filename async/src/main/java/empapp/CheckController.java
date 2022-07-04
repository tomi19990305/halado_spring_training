package empapp;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
@AllArgsConstructor
public class CheckController {

    private JobService jobService;

    @PostMapping
    public CreateJobResponse createJob(){
        return jobService.createJob();
    }


    @GetMapping("{id}")
    public JobStatus getJob(@PathVariable("id") long id){
        return jobService.getJob(id);
    }
}
