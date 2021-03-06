package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

public class DocumentActivity extends AppCompatActivity {

    public final String DOCUMENT_EXTRA = "DocumentExtra";

    private final String DOCUMENT_TEXT_EXAMPLE[] = {

            "Государственная жилищная инспекция Новосибирской области является областным исполнительным органом государственной власти Новосибирской области, уполномоченным на осуществление регионального государственного жилищного надзора на территории Новосибирской области. Функцией инспекции является осуществление регионального государственного жилищного надзора на территории Новосибирской области. Задачами инспекции являются: 1) предупреждение, выявление и пресечение нарушений установленных в соответствии с жилищным законодательством, законодательством об энергосбережении и о повышении энергетической эффективности требований к использованию и сохранности жилищного фонда независимо от его форм собственности, требований энергетической эффективности и оснащенности помещений многоквартирных домов и жилых домов приборами учета используемых энергетических ресурсов.",
            "В установленной сфере деятельности инспекция исполняет следующие полномочия: 1) проводит проверки: а) использования и сохранности жилищного фонда, независимо от его формы собственности, общего имущества собственников помещений в многоквартирном доме, сооружений и элементов инженерной инфраструктуры и придомовых территорий; б) технического состояния жилищного фонда и общего имущества собственников помещений в многоквартирном доме и их инженерного оборудования, сооружений и элементов инженерной инфраструктуры, своевременного выполнения работ по их содержанию и ремонту в соответствии с действующими нормативно-техническими и проектными документами; в) обоснованности устанавливаемых нормативов потребления жилищно-коммунальных услуг; г) осуществления мероприятий по подготовке жилищного фонда и общего имущества собственников помещений в многоквартирном доме, сооружений и элементов инженерной инфраструктуры к сезонной эксплуатации.",
            "ГЖИ ведет: а) реестры уведомлений, указанных в абзацах д, е подпункта 5 настоящего пункта; б) реестр специальных счетов; 5.2) информирует орган местного самоуправления и региональных операторов о многоквартирных домах, собственники помещений в которых не выбрали способ формирования фондов капитального ремонта и (или) не реализовали его; 5.3) предоставляет сведения, указанные в частях 1 - 4 статьи 172 Жилищного кодекса Российской Федерации, в федеральный орган исполнительной власти, осуществляющий функции по выработке и реализации государственной политики и нормативно-правовому регулированию в сфере социально-экономического развития субъектов Российской Федерации и муниципальных образований, строительства, архитектуры, градостроительства (за исключением государственного технического учета и технической инвентаризации объектов капитального строительства) и жилищно-коммунального хозяйства, в порядке, установленном этим федеральным органом."

    };

    TextView name;
    TextView date;
    TextView info;
    EditText text;
    Document document;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);

        name = (TextView)findViewById(R.id.documentName);
        date = (TextView)findViewById(R.id.documentDate);
        info = (TextView)findViewById(R.id.documentInfo);
        text = (EditText)findViewById(R.id.documentText);

        Intent intent = getIntent();
        document = (Document)intent.getSerializableExtra(DOCUMENT_EXTRA);

        name.setText(document.getName());
        info.setText(document.getInfo());
        date.setText(document.getCreationDate().toString());

        Random random = new Random();
        int textCount = Math.abs(random.nextInt()) % 3;
        text.setText(DOCUMENT_TEXT_EXAMPLE[textCount]);
    }
}
