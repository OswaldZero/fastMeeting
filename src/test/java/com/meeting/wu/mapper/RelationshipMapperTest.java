package com.meeting.wu.mapper;

import com.meeting.wu.WuApplication;
import com.meeting.wu.entity.Relationship;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = WuApplication.class)
class RelationshipMapperTest {
    @Autowired
    public RelationshipMapper relationshipMapper;
    @Test
    void insertRelationship() {
        relationshipMapper.insertRelationship(111L,1,1);
    }

    @Test
    void testInsertRelationship() {
        Relationship relationship = relationshipMapper.selectRelationship(3, 20183L);
        System.out.println(relationship);
    }

    @Test
    void testInsertRelationship1() {
        relationshipMapper.insertRelationship(20183L,3,0);
    }
}