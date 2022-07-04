package empapp;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//@Component
@Slf4j
public class StubUsernameListener implements RevisionListener {

    @Autowired
    private ApplicationContext context;

    @Override
    public void newRevision(Object revisionEntity) {
        if (revisionEntity instanceof GlobalRevisionEntity) {
            log.info(context.toString());
            GlobalRevisionEntity globalRevisionEntity = (GlobalRevisionEntity) revisionEntity;
            globalRevisionEntity.setUsername("admin");

            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            log.info(request.getRemoteAddr());
            globalRevisionEntity.setIp(request.getRemoteAddr());

            globalRevisionEntity.setRequestId(request.getHeader("Request-Id"));
        }
    }
}
