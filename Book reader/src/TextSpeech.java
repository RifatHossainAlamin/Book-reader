import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.awt.*;
import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TextSpeech extends JFrame implements  ActionListener
{
    private Container box;
    private JTextArea ta;
    private JButton b1,b2,b3;
    private JLabel l,imgl,footerlabel;
    private ImageIcon img,ico;
    private JScrollPane scrol;
    TextSpeech(){
        workside();
    }

        //container:
        public void workside(){

        img=new ImageIcon(getClass().getResource("3.jpg"));
            image_1();
        //font:
        Font f=new Font("Arial",Font.BOLD,23);
        Font lf=new Font("Arial",Font.BOLD+Font.ITALIC,23);
        //container:
            box=this.getContentPane();
            box.setLayout(null);
            box.setBackground(Color.red);

            //label:
            l=new JLabel("Talking Notepade");
            l.setBounds(100,30,200,30);
            l.setFont(lf);
            l.setBackground(Color.yellow);
            l.setOpaque(true);
            l.setForeground(Color.red);

            //imgl:
            imgl=new JLabel(img);
            imgl.setBounds(450,30,50,50);
            imgl.setFont(f);
            imgl.setBackground(Color.yellow);
            imgl.setOpaque(true);
            imgl.setForeground(Color.red);

            //footer label:
            footerlabel=new JLabel(" Montage Polytechnic Institute");
            footerlabel.setBounds(50,430,350,50);
            footerlabel.setBackground(Color.green);
            footerlabel.setOpaque(true);
            footerlabel.setForeground(Color.red);
            footerlabel.setFont(lf);


            //text area:
            ta=new JTextArea();
            //ta.setBounds(40,100,400,300);
            ta.setFont(f);
            ta.setWrapStyleWord(true);
            ta.setLineWrap(true);

            //scrol:
            scrol=new JScrollPane(ta);
            scrol.setBounds(40,100,400,300);


            //button:

            //Speech button:
            b1=new JButton("START");
            b1.setBounds(450,100,80,40);
            b1.addActionListener(this);

            //reset button:
            b2=new JButton("RESET");
            b2.setBounds(450,160,80,40);
            b2.addActionListener(this);

            //about button:
            b3=new JButton("About");
            b3.setBounds(450,220,80,40);
            b3.addActionListener(this);

            //frame:
            setTitle("Talking Notepade version(1.0)");
            setBounds(250,50,560,550);
            setLayout(null);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setResizable(true);



            //add:
           // box.add(ta);
            box.add(scrol);
            box.add(b1);
            box.add(b2);
            box.add(b3);
            box.add(l);
            box.add(imgl);
            box.add(footerlabel);

            String welcome="Welcome Students. Please enter your text then click start button.";

            voices(welcome);



    }
    //action method:
    public void actionPerformed(ActionEvent e){


            String text,temp;
            text=ta.getText();
            if(e.getSource().equals(b1)){

                 voices(text);

                }else if(e.getSource().equals(b2)){
                ta.setText(" ");
            }else if(e.getSource().equals(b3)){
                String about="Assalamualaikum I'm a talking nodepad. I can read any English text to you. I was developed by Mohammad Alamin Hossain Rifat. Hope I can read your texts well.";
                String w1="Assalamualaikum I'm a talking nodepad. I can read any English text to you. I was developed by Mohammad Alamin Hossain Rifat. I am a desktop software. The components used to build me are: Programming language Java, a framework of Java\n" +
                        "  Swing and TTS driver. Hope I can read your texts well.";
                voices(w1);
            }


        }




    public static void voice(String text) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice textaudio;
        textaudio = VoiceManager.getInstance().getVoice("kevin16");
        if (textaudio != null) {
            textaudio.allocate();
        }
        try {
            textaudio.setRate(85);
            textaudio.setPitch(150);
            textaudio.setVolume(6);
            textaudio.speak(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void voices(String text) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice textaudio;
        textaudio = VoiceManager.getInstance().getVoice("kevin16");
        if (textaudio != null) {
            textaudio.allocate();
        }
        try {
            textaudio.setRate(100);
            textaudio.setPitch(150);
            textaudio.setVolume(6);
            textaudio.speak(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void image_1(){
        ico =new ImageIcon(getClass().getResource("2.png"));
        this.setIconImage(ico.getImage());
    }
    public static void main(String args[])
    {
        TextSpeech ts=new TextSpeech();
    }
}