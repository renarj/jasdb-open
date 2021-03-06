package com.obera.service.acl;

import nl.renarj.jasdb.api.SimpleEntity;
import nl.renarj.jasdb.api.acl.AccessMode;
import nl.renarj.jasdb.api.context.RequestContext;
import nl.renarj.jasdb.core.exceptions.JasDBStorageException;
import nl.renarj.jasdb.service.StorageService;
import org.springframework.aop.framework.Advised;

import java.util.UUID;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Renze de Vries
 */
public class EntityUpdateOperationTest extends AbstractAuthorizationTest {
    public EntityUpdateOperationTest() {
        super(AccessMode.READ, AccessMode.UPDATE);
    }

    @Override
    protected AuthorizationOperation getOperation() {
        return new AuthorizationOperation() {
            @Override
            public void doOperation(StorageService wrappedService, String user, String password) throws Exception {
                SimpleEntity entity = new SimpleEntity(UUID.randomUUID().toString());

                wrappedService.updateEntity(createContext(user, password, "localhost"), entity);
                Advised advised = (Advised) wrappedService;
                StorageService mock = (StorageService) advised.getTargetSource().getTarget();
                verify(mock, times(1)).updateEntity(any(RequestContext.class), eq(entity));
            }
        };
    }
}
