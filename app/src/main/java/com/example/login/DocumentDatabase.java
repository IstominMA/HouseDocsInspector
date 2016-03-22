package com.example.login;


import java.util.ArrayList;
import java.util.Date;

public class DocumentDatabase {

    public static ArrayList<Document> fetch() {
        ArrayList<Document> array = new ArrayList<Document>();

        Document doc1 = new Document("doc1", new Date(), "info");
        array.add(doc1);
        Document doc2 = new Document("doc2", new Date(), "info");
        array.add(doc2);


        return array;
    }



}
