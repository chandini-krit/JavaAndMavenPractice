package org.example;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;

public class JavaVelocityDemo {
    public static void main(String[] args) {
        Velocity velocity=new Velocity();
        velocity.init();

        // Create a Velocity context
        VelocityContext context = new VelocityContext();
        String[] seasons = {"SUMMER","WINTER","AUTUMN","RAINY"};
        // Set data in the context
        context.put("key1","good morning");
        context.put("key2","good noon");
        context.put("seasonArray",seasons);
        context.put("title","harry potter");
        context.put("name","sam");
        context.put("date","14-02-2004");
        context.put("key3",2*3/5+4);
        // Get the template
        Template template = velocity.getTemplate("src/main/resources/mytemplate.vm");
        Template template1 = velocity.getTemplate("src/main/resources/macroTemplate.vm");
        
        // Merge the data with the template
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        System.out.println(writer.toString());
    }
}
