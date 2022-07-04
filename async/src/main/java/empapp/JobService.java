package empapp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class JobService {

    private JobRepository jobRepository;

    private ClientService clientService;

    public CreateJobResponse createJob() {
        Job job = new Job();
        jobRepository.save(job);

        clientService.getStatus(job.getId());

        log.info("createJob end");
        return new CreateJobResponse(job.getId());
    }

    public JobStatus getJob(long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No job found"));
        return new JobStatus(job.getId(), job.getResult());
    }

    @Transactional
    @EventListener
    public void setResult(CallCompletedEvent event){
        Job job = jobRepository.findById(event.getId()).orElseThrow(() -> new IllegalArgumentException("No job found"));
        job.setResult(event.getResult());
    }
}
