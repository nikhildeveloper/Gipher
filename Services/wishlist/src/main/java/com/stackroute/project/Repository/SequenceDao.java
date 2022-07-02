package com.stackroute.project.Repository;

public interface SequenceDao {
    long getNextSequenceId(String key) throws Exception;
}
