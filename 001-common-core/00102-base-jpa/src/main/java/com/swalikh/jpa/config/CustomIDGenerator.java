package com.swalikh.jpa.config;
import com.swalikh.kernel.utils.IDUtils;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import java.io.Serializable;

/**
 * Copyright @2018 nlelpct.
 * @author: 黄磊
 * date:  2019/6/12  10:02
 * use to：自定义主键~
 * modify：
 */
public class CustomIDGenerator extends IdentityGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws MappingException {
        Object id = Long.valueOf(IDUtils.getTimeId());
        if (id != null) {
            return (Serializable) id;
        }
        return super.generate(session, object);
    }
}