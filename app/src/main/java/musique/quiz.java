package musique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import com.example.sn_quiz.R;

import controleur.MainActivity;
import controleur.gameActivity;

public class quiz extends AppCompatActivity {
    public static int juste1;
    public static int MontrerReponse;
    private TextView question11;
    private Button reponse11;
    private Button reponse21;
    private Button reponse31;
    private Button reponse41;
    private Button suite;
    private TextView NbPoint1;

    public static int temp1;
    //public static int MontrerReponse;

    //Question | Op1 | Op2 | Op3 | Op4 | Bonne Réponse
    String[][] questionsMUSIQUE = {
            /*0*/{"La chanteuse londonienne Miss Adkins est mieux connue sous quel nom?", "Adele", "Élisabeth", "Jessica Petenon", "Jessie J", "Adele"},
            /*1*/{"Quel chanteuse a chanté la chanson «Like a Virgin»?", "Madonna", "Miley Cyrus", "Cyndi Lauper", "Cheryl Fernandez-Versini", "Madonna"},
            /*2*/{"Qui est devenu célèbre en 2008 avec la sortie du single «I Kissed a Girl»?", "Madonna", "Katy Perry", "Selena Gomez", "Justin Bieber", "Katy Perry"},
            /*3*/{"Combien de cordes un violon a-t-il habituellement?", "Cinq", "Quatre", "Six", "Sept", "Quatre"},
            /*4*/{"Dans quelle ville américaine Elvis a-t-il été découvert mort en 1977?", "Memphis", "Los Angeles", "Las Vegas", "Macaé", "Memphis"}
            /*5*///{"", "", "", "", "", ""},
            /*6*///{"", "", "", "", "", ""},
            /*7*///{"", "", "", "", "", ""},
            /*8*///{"", "", "", "", "", ""},


            /*n*///{"", "", "", "", "", ""},
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Creation page Quiz avec questions
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        question11 = (TextView) findViewById(R.id.activity_question11_txt);
        reponse11 = (Button) findViewById(R.id.activity_reponse11_btn);
        reponse21 = (Button) findViewById(R.id.activity_reponse21_btn);
        reponse31 = (Button) findViewById(R.id.activity_reponse31_btn);
        reponse41= (Button) findViewById(R.id.activity_reponse41_btn);
        suite = (Button) findViewById(R.id.activity_suite1_btn);
        NbPoint1 = (TextView) findViewById(R.id.activity_NbPoint1_txt);

        //Fonction pour choisir question aleatoirement
        /*public int NombreAleatiore() {
            return (int) ((Math.random() * (0 - 4)) + 0);
            //if not dans ll'array historique
            //Sinon, repeter test aleatoire
        }*/
        int questionChoisi = 2;
        //questionChoisi = (int) ((Math.random() * (1 - 4)) + 1); //ça ne marche pas

        //Fonction pour changer de question chaque fois que le button Next est cliqué
      //  public void ReecrierQuestions() {
            question11.setText(questionsMUSIQUE[questionChoisi][0]);
            reponse11.setText(questionsMUSIQUE[questionChoisi][1]);
            reponse11.setBackgroundColor(Color.parseColor("#FF000000"));
            reponse21.setText(questionsMUSIQUE[questionChoisi][2]);
            reponse21.setBackgroundColor(Color.parseColor("#FF000000"));
            reponse31.setText(questionsMUSIQUE[questionChoisi][3]);
            reponse31.setBackgroundColor(Color.parseColor("#FF000000"));
            reponse41.setText(questionsMUSIQUE[questionChoisi][4]);
            reponse41.setBackgroundColor(Color.parseColor("#FF000000"));

            suite.setEnabled(false);
            juste1 = 0;

      //  };


        /*Corriger ça*/
        reponse11.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //ChangerColeurs(texte du button; array)
                 MontrerReponse(questionChoisi,1);
             }

        });

        reponse21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MontrerReponse(questionChoisi,2);
            }
        });

        reponse31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MontrerReponse(questionChoisi,3);
            }
        });

        reponse41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MontrerReponse(questionChoisi,4);
            }
        });

        suite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionChoisi = RecreerQuestions();
            }
        });
    }

    private void MontrerReponse(int questionActuel, int reponse) {
        //Changer coleurs
        if (questionsMUSIQUE[questionActuel][1] == questionsMUSIQUE[questionActuel][5]) {
            reponse11.setBackgroundColor(Color.parseColor("#90EE90"));
        } else reponse11.setBackgroundColor(Color.parseColor("#FF0000"));

        if (questionsMUSIQUE[questionActuel][2] == questionsMUSIQUE[questionActuel][5]) {
            reponse21.setBackgroundColor(Color.parseColor("#90EE90"));
        } else reponse21.setBackgroundColor(Color.parseColor("#FF0000"));

        if (questionsMUSIQUE[questionActuel][3] == questionsMUSIQUE[questionActuel][5]) {
            reponse31.setBackgroundColor(Color.parseColor("#90EE90"));
        } else reponse31.setBackgroundColor(Color.parseColor("#FF0000"));

        if (questionsMUSIQUE[questionActuel][4] == questionsMUSIQUE[questionActuel][5]) {
            reponse41.setBackgroundColor(Color.parseColor("#90EE90"));
        } else reponse41.setBackgroundColor(Color.parseColor("#FF0000"));

        //Réponse correcte +1
        if (questionsMUSIQUE[questionActuel][reponse] == questionsMUSIQUE[questionActuel][5])
            juste1++;

        suite.setEnabled(true);
        reponse11.setEnabled(false);
        reponse21.setEnabled(false);
        reponse31.setEnabled(false);
        reponse41.setEnabled(false);


        NbPoint1.setText("nombre de points : " + juste1);
    }

    public int RecreerQuestions() {
        int questionSuivante = 3; //Changer pour aleatoire apres et ajouter tableau historique
            question11.setText(questionsMUSIQUE[questionSuivante][0]);
            reponse11.setText(questionsMUSIQUE[questionSuivante][1]);
            reponse11.setBackgroundColor(Color.parseColor("#FF000000"));
            reponse21.setText(questionsMUSIQUE[questionSuivante][2]);
            reponse21.setBackgroundColor(Color.parseColor("#FF000000"));
            reponse31.setText(questionsMUSIQUE[questionSuivante][3]);
            reponse31.setBackgroundColor(Color.parseColor("#FF000000"));
            reponse41.setText(questionsMUSIQUE[questionSuivante][4]);
            reponse41.setBackgroundColor(Color.parseColor("#FF000000"));

            //Réactiver les buttons
            reponse11.setEnabled(true);
            reponse21.setEnabled(true);
            reponse31.setEnabled(true);
            reponse41.setEnabled(true);
            suite.setEnabled(false);

    juste1 = 0;

            //Retourner la question suivante
            return questionSuivante;

    }



}
