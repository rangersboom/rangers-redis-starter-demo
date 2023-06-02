package com.rangers.redis;

import com.rangers.redis.key.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description——
 * Created By Rangers At 2023/6/2
 **/
@Service
public class HelloService {

    @Autowired
    private RedisService redisService;


    public User setObject(String name) {
        RedisKey redisKey = RedisKey.builder().prefix("com.user").suffix(name).build();
        String key = redisKey.of();
        User user = User.builder().userName("张三").address("北京").build();
        redisService.setObject(key,user);
        return redisService.getObject(key);
    }

    public Map<String,User> setMap(String name) {
        RedisKey redisKey = RedisKey.builder().prefix("com.user").suffix(name).build();
        String key = redisKey.of();
        Map<String,User> map = new HashMap<>();
        User user1 = User.builder().userName("张三").address("北京").build();
        map.put("1",user1);
        User user2 = User.builder().userName("李四").address("上海").build();
        map.put("2",user2);
        User user3 = User.builder().userName("王五").address("广州").build();
        map.put("3",user3);

        redisService.setMap(key,map);
        return redisService.getMap(key);
    }

    public List<User> setList(String name) {
        RedisKey redisKey = RedisKey.builder().prefix("com.user").suffix(name).build();
        String key = redisKey.of();

        List<User> list = new ArrayList<>();
        User user1 = User.builder().userName("张三").address("北京").build();
        User user2 = User.builder().userName("李四").address("上海").build();
        User user3 = User.builder().userName("王五").address("广州").build();
        list.add(user1);
        list.add(user2);
        list.add(user3);


        redisService.setList(key,list);
        return redisService.getList(key);
    }

    public Map<String,User> setHash(String name) {
        RedisKey redisKey = RedisKey.builder().prefix("com.user").suffix(name).build();
        String key = redisKey.of();

        Map<String,User> map = new HashMap<>();
        User user1 = User.builder().userName("张三").address("北京").build();
        map.put("1",user1);
        User user2 = User.builder().userName("李四").address("上海").build();
        map.put("2",user2);
        User user3 = User.builder().userName("王五").address("广州").build();
        map.put("3",user3);

        redisService.setMapValue(key,"1",map);
        return redisService.getMapValue(key,"1");
    }
}
