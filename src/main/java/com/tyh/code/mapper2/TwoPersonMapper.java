package com.tyh.code.mapper2;

import com.tyh.code.pojo.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Service;

@Service
public interface TwoPersonMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    @Insert("insert into person (id, name)values(#{id}, #{name})")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=int.class, before=false, statement="select last_insert_id()")
    public int insertPerson(Person person);
}