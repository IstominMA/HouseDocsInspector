package com.example.login;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DocumentDatabase {

    public static ArrayList<Document> fetch() {
        ArrayList<Document> array = new ArrayList<Document>();

        Document doc1 = new Document("doc1", new Date(), "info");
        array.add(doc1);
        Document doc2 = new Document("doc2", new Date(), "info");
        array.add(doc2);

        Calendar calendar = new GregorianCalendar();
        Date documentDate;

        calendar.add(Calendar.DAY_OF_MONTH, -11);
        documentDate = calendar.getTime();
        Document doc3 = new Document("doc3", documentDate, "info");
        array.add(doc3);
        Document doc4 = new Document("doc4", documentDate, "info");
        array.add(doc4);

        calendar.add(Calendar.DAY_OF_MONTH, -11);
        documentDate = calendar.getTime();
        Document doc5 = new Document("doc5", documentDate, "info");
        array.add(doc5);
        Document doc6 = new Document("doc6", documentDate, "info");
        array.add(doc6);

        return array;
    }



}
