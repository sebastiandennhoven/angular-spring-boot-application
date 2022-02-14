package com.sd.usertask.operations;

import java.util.Comparator;

import com.sd.usertask.entities.*;

public class CustomComparator implements Comparator<UserEntity> {
    @Override
    public int compare(UserEntity o1, UserEntity o2) {
        return Long.compare(o2.getTimeAdded(), o1.getTimeAdded());
    }
}
