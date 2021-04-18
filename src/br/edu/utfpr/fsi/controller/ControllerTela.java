package br.edu.utfpr.fsi.controller;


import br.edu.utfpr.fsi.service.Estrela;
import br.edu.utfpr.fsi.service.GeradorMatriz;
import br.edu.utfpr.fsi.service.Largura;
import br.edu.utfpr.fsi.model.Nodo;
import br.edu.utfpr.fsi.service.Gulosa;
import br.edu.utfpr.fsi.service.Profundidade;
import br.edu.utfpr.fsi.view.Tela;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControllerTela {
    
    private final Tela            tela;
    private final JPanel[][]      mapa;
    private final String          defaultPath;
    private final int             velocidade;
    private Estrela               estrela ;
    private Largura               largura;
    private Gulosa                gulosa;
    private Profundidade          profundidade;
    private List<List<Nodo>>      a;
    
    private static final String RECOMPENSA  = "recompensa.png";
    private static final String AGENTE      = "agente.png";
    private static final String MOEDA       = "moeda.png";
    private static final String PAREDE      = "parede.png";
    
    public ControllerTela(Tela tela){
        this.tela           = tela;
        this.mapa           = new JPanel[10][10];
        this.defaultPath    = "/br/edu/utfpr/fsi/imagens/";
        this.a              = new GeradorMatriz().getGrafo();
        velocidade          = 1000;
        tela.getjPanelMenu2().setBackground(Color.WHITE);
    }
    
    
    public void iniciarBusca(String destino){
            
            estrela = new Estrela(a);
            List<String> string = estrela.busca(destino);
            tela.getjButtonIniciar().setEnabled(false);
            tela.getjLabelFraseStatus().setText("Buscando!");
            new Thread(new Runnable() {
                public void run() {
                    string.forEach((x)->{
                        try {
                            String aux[];
                            aux = x.split("x");
                            ((JLabel)(mapa[Integer.valueOf(aux[0])][Integer.valueOf(aux[1])].getComponent(0))).setIcon(
                                    new ImageIcon(getClass().getResource( defaultPath + AGENTE))
                            );
                            
                            Thread.sleep(velocidade);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControllerTela.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    Integer x = 0;
                    Integer y = 0;
                    String vet[]= destino.split("x");
                    
                    x = Integer.valueOf(vet[0]);
                    y = Integer.valueOf(vet[1]);

                    ((JLabel)(mapa[x][y].getComponent(0))).setIcon(
                        new ImageIcon(getClass().getResource( defaultPath + RECOMPENSA))
                        );
                    tela.getjTextFielExp().setText(String.valueOf(estrela.getI()));
                    tela.getjTextFieldCam().setText(String.valueOf(string.size()));
                    tela.getjButton1().setEnabled(true);
                    tela.getjButtonGerar().setEnabled(!true);
                    tela.getjLabelFraseStatus().setText("Finalizado!");
                }
               }).start();
 
    }
    public void iniciarBuscaLargura(String destino) throws InterruptedException{
            tela.getjButtonIniciar().setEnabled(false);
            tela.getjLabelFraseStatus().setText("Buscando...");
            largura = new Largura(a);
            List<String> string = largura.largura(destino);

             new Thread(new Runnable() {
                public void run() {
                    string.forEach((x)->{
                        try {
                            String aux[];
                            aux = x.split("x");
                            ((JLabel)(mapa[Integer.valueOf(aux[0])][Integer.valueOf(aux[1])].getComponent(0))).setIcon(
                                    new ImageIcon(getClass().getResource( defaultPath + AGENTE))
                            );
                            
                            Thread.sleep(velocidade);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControllerTela.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    Integer x = 0;
                    Integer y = 0;
                    String vet[]= destino.split("x");
                    
                    x = Integer.valueOf(vet[0]);
                    y = Integer.valueOf(vet[1]);

                    ((JLabel)(mapa[x][y].getComponent(0))).setIcon(
                        new ImageIcon(getClass().getResource( defaultPath + RECOMPENSA))
                        );
                    tela.getjTextFielExp().setText(String.valueOf(largura.getI()));
                    tela.getjTextFieldCam().setText(String.valueOf(string.size()));
                    tela.getjButton1().setEnabled(true);
                    tela.getjButtonGerar().setEnabled(!true);
                    tela.getjLabelFraseStatus().setText("Finalizado!");
                }
               }).start();

    }
    public void iniciarBuscaGulosa(String destino) {
        tela.getjLabelFraseStatus().setText("Buscando...");
        tela.getjButtonIniciar().setEnabled(false);
        gulosa = new Gulosa(a);
        List<String> string = gulosa.busca(destino);

        new Thread(new Runnable() {
            public void run() {
                string.forEach((x)->{
                    try {
                        String aux[];
                        aux = x.split("x");
                        ((JLabel)(mapa[Integer.valueOf(aux[0])][Integer.valueOf(aux[1])].getComponent(0))).setIcon(
                                new ImageIcon(getClass().getResource( defaultPath + AGENTE))
                        );

                        Thread.sleep(velocidade);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ControllerTela.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }); 
                Integer x = 0;
                Integer y = 0;
                String vet[]= destino.split("x");

                x = Integer.valueOf(vet[0]);
                y = Integer.valueOf(vet[1]);

                ((JLabel)(mapa[x][y].getComponent(0))).setIcon(
                    new ImageIcon(getClass().getResource( defaultPath + RECOMPENSA))
                    );
                tela.getjTextFielExp().setText(String.valueOf(gulosa.getI()));
                tela.getjTextFieldCam().setText(String.valueOf(string.size()));
                tela.getjButton1().setEnabled(true);
                tela.getjButtonGerar().setEnabled(!true);
                tela.getjLabelFraseStatus().setText("Finalizado!");
            }
           }).start();    
    
    }

    public void iniciarBuscaProfundidade(String destino) {
        
        tela.getjLabelFraseStatus().setText("Buscando...");
        tela.getjButtonIniciar().setEnabled(false);
        profundidade = new Profundidade(a);
        List<String> string = profundidade.busca(destino);
        
        new Thread(new Runnable() {
                public void run() {
                    string.forEach((x)->{
                        try {
                            String aux[];
                            aux = x.split("x");
                            ((JLabel)(mapa[Integer.valueOf(aux[0])][Integer.valueOf(aux[1])].getComponent(0))).setIcon(
                                    new ImageIcon(getClass().getResource( defaultPath + AGENTE))
                            );
                            
                            Thread.sleep(velocidade);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ControllerTela.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    Integer x = 0;
                    Integer y = 0;
                    String vet[]= destino.split("x");
                    
                    x = Integer.valueOf(vet[0]);
                    y = Integer.valueOf(vet[1]);

                    ((JLabel)(mapa[x][y].getComponent(0))).setIcon(
                        new ImageIcon(getClass().getResource( defaultPath + RECOMPENSA))
                        );
                    tela.getjTextFielExp().setText(String.valueOf(profundidade.getI()));
                    tela.getjTextFieldCam().setText(String.valueOf(string.size()));
                    tela.getjButton1().setEnabled(true);
                    tela.getjButtonGerar().setEnabled(!true);
                    tela.getjLabelFraseStatus().setText("Finalizado!");
                }
               }).start();
    }

    public void gerarMapa(String destino){
        tela.getjButton1().setEnabled(!true);
        tela.getjButtonGerar().setEnabled(!true);
        List<List<Nodo>> grafo = this.a;
        this.definirMatriz();
        tela.getjLabelFraseStatus().setText("Gerando Mapa");
        
        new Thread(new Runnable() {
                public void run() {
                    
                    for(int i=0; i<10; i++){
            
                        for(int j=0; j<10; j++){

                            switch (grafo.get(i).get(j).getCusto()) {
                                case 1:
                                    mapa[i][j].setBackground(Color.WHITE);
                                    break;
                                case 10:
                                    mapa[i][j].setBackground(Color.GRAY);
                                    break;
                                case 4:
                                    mapa[i][j].setBackground(Color.YELLOW);
                                    break;
                                case 20:
                                    mapa[i][j].setBackground(Color.GREEN);
                                    break;
                                case 1000:
                                    mapa[i][j].setBackground(Color.WHITE);
                                    ((JLabel)(mapa[i][j].getComponent(0))).setIcon(
                                        new ImageIcon(getClass().getResource( defaultPath + PAREDE))
                                        );
                                    break;
                                default:
                                    ((JLabel)(mapa[i][j].getComponent(0))).setIcon(
                                        new ImageIcon(getClass().getResource( defaultPath + MOEDA))
                                        );
                                    break;
                            }

                            if(i==0 && j==0){
                                ((JLabel)(mapa[i][j].getComponent(0))).setIcon(
                                    new ImageIcon(getClass().getResource( defaultPath + AGENTE))
                                    );
                            }
                            if(destino.equals(String.valueOf(i)+"x"+String.valueOf(j))){
                                mapa[i][j].setBackground(Color.WHITE);
                                ((JLabel)(mapa[i][j].getComponent(0))).setIcon(
                                    new ImageIcon(getClass().getResource( defaultPath + RECOMPENSA))
                                    );
                            }     
                            try {
                                Thread.sleep(40);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ControllerTela.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    tela.getjButtonIniciar().setEnabled(true);
                    tela.getjLabelFraseStatus().setText("Pronto para iniciar!");
                }
               }).start();

    }
    
    public List<List<Nodo>> resetarMapa(){
        tela.getjButton1().setEnabled(!true);
        tela.getjButtonIniciar().setEnabled(!true);
        tela.getjButtonGerar().setEnabled(true);
        for(int i = 0; i<10;i++){
            for(int j=0;j<10;j++){
                 ((JLabel)(mapa[i][j].getComponent(0))).setIcon(null);
                mapa[i][j].setBackground(Color.LIGHT_GRAY);
                
                
            }
        }
        tela.getjLabelFraseStatus().setText("Deve gerar mapa");
        return this.a = new GeradorMatriz().getGrafo();
    }
    
    public void definirMatriz(){
        
        mapa[0][0] = tela.getjPanel1();
        mapa[0][1] = tela.getjPanel2();
        mapa[0][2] = tela.getjPanel3();
        mapa[0][3] = tela.getjPanel4();
        mapa[0][4] = tela.getjPanel5();
        mapa[0][5] = tela.getjPanel6();
        mapa[0][6] = tela.getjPanel7();
        mapa[0][7] = tela.getjPanel8();
        mapa[0][8] = tela.getjPanel9();
        mapa[0][9] = tela.getjPanel10();
        
        mapa[1][0] = tela.getjPanel11();
        mapa[1][1] = tela.getjPanel12();
        mapa[1][2] = tela.getjPanel13();
        mapa[1][3] = tela.getjPanel14();
        mapa[1][4] = tela.getjPanel15();
        mapa[1][5] = tela.getjPanel16();
        mapa[1][6] = tela.getjPanel17();
        mapa[1][7] = tela.getjPanel18();
        mapa[1][8] = tela.getjPanel19();
        mapa[1][9] = tela.getjPanel20();
        
        mapa[2][0] = tela.getjPanel21();
        mapa[2][1] = tela.getjPanel22();
        mapa[2][2] = tela.getjPanel23();
        mapa[2][3] = tela.getjPanel24();
        mapa[2][4] = tela.getjPanel25();
        mapa[2][5] = tela.getjPanel26();
        mapa[2][6] = tela.getjPanel27();
        mapa[2][7] = tela.getjPanel28();
        mapa[2][8] = tela.getjPanel146();
        mapa[2][9] = tela.getjPanel30();
        
        mapa[3][0] = tela.getjPanel31();
        mapa[3][1] = tela.getjPanel32();
        mapa[3][2] = tela.getjPanel33();
        mapa[3][3] = tela.getjPanel34();
        mapa[3][4] = tela.getjPanel35();
        mapa[3][5] = tela.getjPanel36();
        mapa[3][6] = tela.getjPanel37();
        mapa[3][7] = tela.getjPanel38();
        mapa[3][8] = tela.getjPanel39();
        mapa[3][9] = tela.getjPanel40();
        
        mapa[4][0] = tela.getjPanel41();
        mapa[4][1] = tela.getjPanel42();
        mapa[4][2] = tela.getjPanel43();
        mapa[4][3] = tela.getjPanel44();
        mapa[4][4] = tela.getjPanel45();
        mapa[4][5] = tela.getjPanel46();
        mapa[4][6] = tela.getjPanel47();
        mapa[4][7] = tela.getjPanel48();
        mapa[4][8] = tela.getjPanel49();
        mapa[4][9] = tela.getjPanel50();
        
        mapa[5][0] = tela.getjPanel51();
        mapa[5][1] = tela.getjPanel52();
        mapa[5][2] = tela.getjPanel53();
        mapa[5][3] = tela.getjPanel54();
        mapa[5][4] = tela.getjPanel55();
        mapa[5][5] = tela.getjPanel56();
        mapa[5][6] = tela.getjPanel57();
        mapa[5][7] = tela.getjPanel58();
        mapa[5][8] = tela.getjPanel59();
        mapa[5][9] = tela.getjPanel60();
        
        mapa[6][0] = tela.getjPanel61();
        mapa[6][1] = tela.getjPanel62();
        mapa[6][2] = tela.getjPanel63();
        mapa[6][3] = tela.getjPanel64();
        mapa[6][4] = tela.getjPanel65();
        mapa[6][5] = tela.getjPanel66();
        mapa[6][6] = tela.getjPanel67();
        mapa[6][7] = tela.getjPanel68();
        mapa[6][8] = tela.getjPanel69();
        mapa[6][9] = tela.getjPanel70();
        
        mapa[7][0] = tela.getjPanel71();
        mapa[7][1] = tela.getjPanel72();
        mapa[7][2] = tela.getjPanel73();
        mapa[7][3] = tela.getjPanel74();
        mapa[7][4] = tela.getjPanel75();
        mapa[7][5] = tela.getjPanel76();
        mapa[7][6] = tela.getjPanel77();
        mapa[7][7] = tela.getjPanel78();
        mapa[7][8] = tela.getjPanel79();
        mapa[7][9] = tela.getjPanel80();
        
        mapa[8][0] = tela.getjPanel81();
        mapa[8][1] = tela.getjPanel82();
        mapa[8][2] = tela.getjPanel83();
        mapa[8][3] = tela.getjPanel84();
        mapa[8][4] = tela.getjPanel85();
        mapa[8][5] = tela.getjPanel86();
        mapa[8][6] = tela.getjPanel87();
        mapa[8][7] = tela.getjPanel88();
        mapa[8][8] = tela.getjPanel89();
        mapa[8][9] = tela.getjPanel90();
        
        mapa[9][0] = tela.getjPanel91();
        mapa[9][1] = tela.getjPanel92();
        mapa[9][2] = tela.getjPanel93();
        mapa[9][3] = tela.getjPanel94();
        mapa[9][4] = tela.getjPanel95();
        mapa[9][5] = tela.getjPanel96();
        mapa[9][6] = tela.getjPanel97();
        mapa[9][7] = tela.getjPanel98();
        mapa[9][8] = tela.getjPanel99();
        mapa[9][9] = tela.getjPanel100();
        
    }

}
