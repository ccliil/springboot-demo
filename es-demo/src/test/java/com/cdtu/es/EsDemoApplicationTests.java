package com.cdtu.es;

import com.cdtu.es.pojo.Item;
import com.cdtu.es.reposirory.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDemoApplicationTests {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void contextLoads() {
        elasticsearchTemplate.createIndex(Item.class);
        elasticsearchTemplate.putMapping(Item.class);
    }
    @Test
    public void testDelete(){
        //elasticsearchTemplate.deleteIndex("item");
        elasticsearchTemplate.delete(Item.class,"1");//根据id删除某一项
    }
    @Test
    public void index() {
        Item item=new Item(1L,"小米手机7","手机","小米",5999.00,null);
        itemRepository.save(item);
    }
    @Test
    public void indexList(){
        List<Item> list=new ArrayList<>();
        list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, null));
        list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00,null));
        itemRepository.saveAll(list);
    }
//    @Test
//    public void testFind(){
//        Iterable<Item> items=this.itemRepository.findAll(Sort.by(Sort.Direction.DESC,"price"));
//        //items.forEach(item -> System.out.println(item));
//        System.out.println(items);
//        items.forEach(System.out::println);
//    }
    @Test
    public void testFind(){ // 查询全部，并按照价格降序排序    
        Iterable<Item> items = this.itemRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
        items.forEach(item-> System.out.println(item));
    }

}
