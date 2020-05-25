package com.wyl.research.validUser;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/24
 */
public class ValidUtils {
    private List<Valid> valids = new ArrayList<>();


    public ValidUtils build(Valid valid) {
        this.valids.add(valid);
        return this;
    }

    public void valid() {
        if (!CollectionUtils.isEmpty(valids)) {
            for (Valid valid : valids) {
                valid.valid();
            }
        }

    }

}
