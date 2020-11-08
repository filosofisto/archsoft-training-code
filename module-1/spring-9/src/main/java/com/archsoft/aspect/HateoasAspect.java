package com.archsoft.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Aspect
@Component
public class HateoasAspect implements Ordered {

    @Around("@annotation(Hateoas)")
    public Object aroundHateoas(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object ret = proceedingJoinPoint.proceed();

        applyHateoas(ret);

        return ret;
    }

    private void applyHateoas(Object ret) throws com.archsoft.exception.RecordNotFoundException {
        if (ret instanceof ResponseEntity) {
            ResponseEntity responseEntity = (ResponseEntity) ret;
            Object body = responseEntity.getBody();

            if (body instanceof ApplyHateoas) {
                applyHateoasSingle((ApplyHateoas) body);
            } else if (body instanceof Page) {
                applyHateoasPage((Page<ApplyHateoas>) body);
            } else if (body instanceof PagedModel) {
                applyHateoasPage((PagedModel<EntityModel<ApplyHateoas>>) body);
            }
        }
    }

    private void applyHateoasPage(PagedModel<EntityModel<ApplyHateoas>> pagedModel) throws com.archsoft.exception.RecordNotFoundException {
        Iterator<EntityModel<ApplyHateoas>> it = pagedModel.iterator();
        while (it.hasNext()) {
            it.next().getContent().apply();
        }
    }

    private void applyHateoasPage(Page<ApplyHateoas> page) throws com.archsoft.exception.RecordNotFoundException {
        Iterator<ApplyHateoas> it = page.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
    }

    private void applyHateoasSingle(ApplyHateoas applyHateoas) throws com.archsoft.exception.RecordNotFoundException {
        applyHateoas.apply();
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
