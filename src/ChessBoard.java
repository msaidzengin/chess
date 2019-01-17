import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class ChessBoard {

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private JPanel chessBoard;
    private String[][] strChessBoard = new String[][] { {"RB", "NB", "BB", "QB", "KB", "BB", "NB", "RB" }, {"PB", "PB", "PB", "PB", "PB", "PB", "PB", "PB"}, {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "}, {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "}, {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "}, {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "}, {"PW", "PW", "PW", "PW", "PW", "PW", "PW", "PW"}, {"RW", "NW", "BW", "QW", "KW", "BW", "NW", "RW"} };

    private ImageIcon rookBlack = new ImageIcon(System.getProperty("user.dir") + "/images/BlackRook.png");

    private ImageIcon rookWhite = new ImageIcon(System.getProperty("user.dir") + "/images/WhiteRook.png");

    private ImageIcon bishopBlack = new ImageIcon(System.getProperty("user.dir") + "/images/BlackBishop.png");

    private ImageIcon bishopWhite = new ImageIcon(System.getProperty("user.dir") + "/images/WhiteBishop.png");

    private ImageIcon knightBlack = new ImageIcon(System.getProperty("user.dir") + "/images/BlackKnight.png");

    private ImageIcon knightWhite = new ImageIcon(System.getProperty("user.dir") + "/images/WhiteKnight.png");

    private ImageIcon kingBlack = new ImageIcon(System.getProperty("user.dir") + "/images/BlackKing.png");

    private ImageIcon kingWhite = new ImageIcon(System.getProperty("user.dir") + "/images/WhiteKing.png");

    private ImageIcon queenBlack = new ImageIcon(System.getProperty("user.dir") + "/images/BlackQueen.png");

    private ImageIcon queenWhite = new ImageIcon(System.getProperty("user.dir") + "/images/WhiteQueen.png");

    private ImageIcon pawnBlack = new ImageIcon(System.getProperty("user.dir") + "/images/BlackPawn.png");

    private ImageIcon pawnWhite = new ImageIcon(System.getProperty("user.dir") + "/images/WhitePawn.png");

    private boolean boolMoveSelection = false, bWhite = true, bMyTurn = true;

    private Point pntMoveFrom, pntMoveTo;

    private Container c;
    private  JLabel message = new JLabel(
            "Chess Champ is ready to play!");
    private static  String COLS = "ABCDEFGH";
    final JFrame f = new JFrame("ChessChamp");
    SwingWorker worker;
    public  JComponent getGui() {
        return gui;
    }
    ChessBoard() {
        initializeGui();
        
         worker = new SwingWorker() {
            
            

            

			@Override
			protected Object doInBackground() throws Exception {
				// TODO Auto-generated method stub
				f.add(gui);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
				return null;
			}
                
            //}
        };
       // SwingUtilities.invokeLater(r);
        worker.execute();
    }

    public  void initializeGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("New")); // TODO - add functionality!
        tools.add(new JButton("Save")); // TODO - add functionality!
        tools.add(new JButton("Restore")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(new JButton("Resign")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(message);

        gui.add(new JLabel("?"), BorderLayout.LINE_START);

        chessBoard = new JPanel(new GridLayout(0, 9));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);

        // create the chess board squares
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our chess pieces are 90x90 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(90, 90, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        //) {
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.GRAY);
                }
                chessBoardSquares[jj][ii] = b;
            }
        }
        //taÅŸlarÄ± teker teker yerlestirmek icin
        for (int ii=0;ii<8;ii++){
        	for (int jj=0;jj<8;jj++){
        		if(jj==0||jj==1||jj==6||jj==7){
        			if(jj==0&&ii==0){
        				chessBoardSquares[jj][ii].add(new JLabel(this.rookBlack));
        			}
        			else if(jj==0&&ii==1){
        				chessBoardSquares[jj][ii].add(new JLabel(this.knightBlack));
        			}
        			else if(jj==0&&ii==2){
        				chessBoardSquares[jj][ii].add(new JLabel(this.bishopBlack));
        			}
        			else if(jj==0&&ii==3){
        				chessBoardSquares[jj][ii].add(new JLabel(this.queenBlack));
        			}
        			else if(jj==0&&ii==4){
        				chessBoardSquares[jj][ii].add(new JLabel(this.kingBlack));
        			}
        			else if(jj==0&&ii==5){
        				chessBoardSquares[jj][ii].add(new JLabel(this.bishopBlack));
        			}
        			else if(jj==0&&ii==6){
        				chessBoardSquares[jj][ii].add(new JLabel(this.knightBlack));
        			}
        			else if(jj==0&&ii==7){
        				chessBoardSquares[jj][ii].add(new JLabel(this.rookBlack));
        			}
        			else if(jj==1){
        				chessBoardSquares[jj][ii].add(new JLabel(this.pawnBlack));
        			}
        			if(jj==7&&ii==0){
        				chessBoardSquares[jj][ii].add(new JLabel(this.rookWhite));
        			}
        			else if(jj==7&&ii==1){
        				chessBoardSquares[jj][ii].add(new JLabel(this.knightWhite));
        			}
        			else if(jj==7&&ii==2){
        				chessBoardSquares[jj][ii].add(new JLabel(this.bishopWhite));
        			}
        			else if(jj==7&&ii==3){
        				chessBoardSquares[jj][ii].add(new JLabel(this.queenWhite));
        			}
        			else if(jj==7&&ii==4){
        				chessBoardSquares[jj][ii].add(new JLabel(this.kingWhite));
        			}
        			else if(jj==7&&ii==5){
        				chessBoardSquares[jj][ii].add(new JLabel(this.bishopWhite));
        			}
        			else if(jj==7&&ii==6){
        				chessBoardSquares[jj][ii].add(new JLabel(this.knightWhite));
        			}
        			else if(jj==7&&ii==7){
        				chessBoardSquares[jj][ii].add(new JLabel(this.rookWhite));
        			}
        			else if(jj==6){
        				chessBoardSquares[jj][ii].add(new JLabel(this.pawnWhite));
        			}
        		}
        	}
        }
        //fill the chess board
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                    SwingConstants.CENTER));
        	/*chessBoard.add(
                    new JLabel(this.pawnWhite));*/
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (8-ii),
                                SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[ii][jj]);
                }
            }
        }
    }
    public  void putIcon(int x,int y,String s,char c) {// Ã¶devdeki putIcon metodu
    	f.setVisible(false);
        f.dispose();
        worker.cancel(true);
    	if(s.equals("kale")&&c=='s'){
    	   chessBoardSquares[x][y].add(new JLabel(this.rookBlack));
    	}
    	else if(s.equals("kale")&&c=='b'){
    		chessBoardSquares[x][y].add(new JLabel(this.rookWhite));
    	}
    	else if(s.equals("fil")&&c=='s'){
    		chessBoardSquares[x][y].add(new JLabel(this.bishopBlack));
    	}
    	else if(s.equals("fil")&&c=='b'){
    		chessBoardSquares[x][y].add(new JLabel(this.bishopWhite));
    	}
    	else if(s.equals("at")&&c=='s'){
    		chessBoardSquares[x][y].add(new JLabel(this.knightBlack));
    	}
    	else if(s.equals("at")&&c=='b'){
    		chessBoardSquares[x][y].add(new JLabel(this.knightWhite));
    	}
    	else if(s.equals("piyon")&&c=='s'){
    		chessBoardSquares[x][y].add(new JLabel(this.pawnBlack));
    	}
    	else if(s.equals("piyon")&&c=='b'){
    		chessBoardSquares[x][y].add(new JLabel(this.pawnWhite));
    	}
    	else if(s.equals("vezir")&&c=='s'){
    		chessBoardSquares[x][y].add(new JLabel(this.queenBlack));
    	}
    	else if(s.equals("vezir")&&c=='b'){
    		chessBoardSquares[x][y].add(new JLabel(this.queenWhite));
    	}
    	else if(s.equals("sah")&&c=='s'){
    		chessBoardSquares[x][y].add(new JLabel(this.kingBlack));
    	}
    	else if(s.equals("sah")&&c=='b'){
    		chessBoardSquares[x][y].add(new JLabel(this.kingWhite));
    	}
    	 worker = new SwingWorker() {
            
            

            

			@Override
			protected Object doInBackground() throws Exception {
				// TODO Auto-generated method stub
				f.add(gui);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
				return null;
			}
                
            //}
        };
       // SwingUtilities.invokeLater(r);
        worker.execute();
    }
    public  void removeIcon(int x,int y,String s,char c) {//Ã¶devdeki removeIcon metodu
    	f.setVisible(false);
        f.dispose();
        worker.cancel(true);
    	Insets buttonMargin = new Insets(0,0,0,0);
    	JButton b = new JButton();
        b.setMargin(buttonMargin);
        ImageIcon icon = new ImageIcon(
                new BufferedImage(90, 90, BufferedImage.TYPE_INT_ARGB));
        b.setIcon(icon);
        if ((x % 2 == 1 && y % 2 == 1)
                //) {
                || (x % 2 == 0 && y % 2 == 0)) {
            b.setBackground(Color.WHITE);
        } else {
            b.setBackground(Color.GRAY);
        }
        chessBoardSquares[x][y].remove(0);
        //chessBoardSquares[x][y] = b;
 worker = new SwingWorker() {
            
            

            

			@Override
			protected Object doInBackground() throws Exception {
				// TODO Auto-generated method stub
				f.add(gui);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
				return null;
			}
                
            //}
        };
       // SwingUtilities.invokeLater(r);
        worker.execute();
    }
    public  JComponent getChessBoard() {
        return chessBoard;
    }

   

    
}
