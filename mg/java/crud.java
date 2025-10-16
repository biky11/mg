import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.client.result.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import java.util.Arrays;
import java.util.List;
public class crud {
    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017/";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase db = mongoClient.getDatabase("tyit");

            MongoCollection<Document> collection = db.getCollection("stud");

//create -- insert
            Document ndoc=new Document("name","sigma").append("roll","07").append("city","kasal");
            collection.insertOne(ndoc);
            System.out.println("Inserted doc : "+ndoc.toJson());

//read one 
            Document rdoc=collection.find(eq("name","Ancel")).first();
            System.out.println("read doc : "+rdoc.toJson());

//read --- read all

            FindIterable<Document> docs = collection.find();

            for (Document doc : docs) {
                System.out.println("Found: " + doc.toJson());
            }

//update----
            UpdateResult ur=collection.updateOne(eq("name","Sujal"),set("age","03"));
            System.out.println("Modified docment : "+ur.getModifiedCount());
            System.out.println("matched document :"+ur.getMatchedCount());

            Document fdoc=collection.find(eq("age","03")).first();
            System.out.println("updated document : "+fdoc.toJson());

//delete-----
            DeleteResult dr=collection.deleteOne(eq("name","sigma"));
            System.out.println("deleted cout : "+dr.getDeletedCount());

            //read
            FindIterable<Document> docs2=collection.find();
            for(Document doc3: docs2 ){
                System.out.println(doc3.toJson());
            }

//insert many
            List<Document> docsToInsert = Arrays.asList(
                new Document("name","Alice").append("roll","08").append("city","Delhi"),
                new Document("name","Bob").append("roll","09").append("city","Mumbai"),
                new Document("name","Charlie").append("roll","10").append("city","Kolkata"),
                new Document("name","Sujal").append("roll","11").append("city","Chennai"),
                new Document("name","Sujal").append("roll","12").append("city","Bangalore")
            );
            collection.insertMany(docsToInsert);
            System.out.println("Inserted multiple documents:");
            for (Document doc : docsToInsert) {
                System.out.println(doc.toJson());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



  // --- insert many ---

//javac -cp ";.lib/*" crud.java
//java -cp ";.lib/*" curd
