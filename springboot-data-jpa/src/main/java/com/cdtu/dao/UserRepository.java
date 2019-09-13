package com.cdtu.dao;

import com.cdtu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {//继承JpaRepository<T,ID>来完成对数据库的操作，T:实体对象 ID:实体对象对应的主键(需要与配置文件一起使用生效)
}
