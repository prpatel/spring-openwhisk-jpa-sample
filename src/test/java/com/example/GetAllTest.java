package com.example;
import com.google.gson.JsonObject;
import com.ibm.openwhisk.spring.GetAllBlogEntries;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple function.
 */
public class GetAllTest {
  @Test
  public void testFunction() {
    JsonObject args = new JsonObject();
    args.addProperty("name", "TestValue");
    JsonObject response = GetAllBlogEntries.main(args);
    assertNotNull(response);
    String result = response.toString();
    assertNotNull(result);
//    assertEquals("{\"result\":[{\"id\":1,\"title\":\"TEST TITLE\",\"body\":\"TEST BODY\",\"author\":\"prpatel\",\"published\":false}]}", result);
  }
}


