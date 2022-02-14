package datastructurewithapplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Umut
 */
public class JavaApplet extends JApplet{
    Button btn1, btn2, btn3, btn4, btn5, btnAdd, btnRemove, btnShow;
    Button[] buttonsOfArrayQueue;
    Button[] buttonsOfLinkedList;
    Label[] labelsOfArrayQueue;
    TextField inputTextFiled;
    int sizeOfLinkedList;
    ArrayStack arrStack;
    ArrayQueue arrQueue;
    LLStack lls;
    LLQueue llq;
    String menu = "main";
    
    @Override
    public void init() {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        resize(1400, 900);
        setLayout(null);
        sizeOfLinkedList = 0;
        
        initObjects();
        setColorsOfObjects();
        setBoundriesOfObjects();
        
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        
        btn1Action();
        btn2Action();
        btn3Action();
        btn4Action();
        btn5Action();
        btnAddAction();
        btnRemoveAction();
        btnShowAction();
    }
    
    void initObjects(){
        arrStack = new ArrayStack(10);
        arrQueue = new ArrayQueue(10);
        lls = new LLStack();
        llq = new LLQueue();
        buttonsOfLinkedList = new Button[32];
        buttonsOfArrayQueue = new Button[10];
        labelsOfArrayQueue = new Label[10];
        btn1 = new Button("Stack Using Array");
        btn2 = new Button("Queue Using Array");
        btn3 = new Button("Stack Using Linkedlist");
        btn4 = new Button("Queue Using Linkedlist");
        btn5 = new Button("Main Manu");
        btnAdd = new Button("Add()");
        btnRemove = new Button("Remove()");
        btnShow = new Button("Show()");
        inputTextFiled = new TextField();
        for (int i = 0; i < 10; i++) {
            labelsOfArrayQueue[i] = new Label();
            labelsOfArrayQueue[i].setBackground(Color.lightGray);
            labelsOfArrayQueue[i].setBounds(510, 605 - 25*i, 50, 15);
        }
        for (int i = 0; i < 10; i++) {
            buttonsOfArrayQueue[i] = new Button();
            buttonsOfArrayQueue[i].setBounds(510, 605 - 25*i, 50, 15);
        }
        int newLine = 0;
        for (int i = 1; i <= 32; i++){
            newLine += ((i)%8 == 0 ? 100 : 0);
            buttonsOfLinkedList[i-1] = new Button();
            buttonsOfLinkedList[i-1].setBounds(375 + ((i)%8)*(75), 250 + newLine, 50, 15);
        }
    }
    
    void setColorsOfObjects(){
        btn1.setBackground(Color.green);
        btn2.setBackground(Color.green);
        btn3.setBackground(Color.green);
        btn4.setBackground(Color.green);
    }
    
    void setBoundriesOfObjects(){
        btn1.setBounds(600, 200, 150, 100);
        btn2.setBounds(600, 300, 150, 100);
        btn3.setBounds(600, 400, 150, 100);
        btn4.setBounds(600, 500, 150, 100);
        btn5.setBounds(1300, 800, 100, 100);
        btnAdd.setBounds(450, 100, 150, 100);
        btnRemove.setBounds(600, 100, 150, 100);
        btnShow.setBounds(750, 100, 150, 100);
        inputTextFiled.setBounds(600, 200, 150, 25);
    }


    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.
        int newLine;
        switch (menu) {
            case "stack":
                grphcs.drawRect(350, 225, 700, 550);
                for (int i = 0; i < 10; i++) {
                    grphcs.drawString(""+i, 490, 615 - 25*i);
                    grphcs.drawRect(500, 600 - 25*i, 100, 25);
                    add(labelsOfArrayQueue[i]);
                    
                }
                drawArrow(grphcs, 610, 615 - 25 * arrStack.index, 15, "head", "left");
                break;
                
            case "queue":
                grphcs.drawRect(350, 225, 700, 550);
                for (int i = 0; i < 10; i++) {
                    grphcs.drawString(""+i, 490, 615 - 25*i);
                    add(buttonsOfArrayQueue[i]);
                }
                drawArrow(grphcs, 610, 615 - 25 * (arrQueue.count-1), 50, "rear", "left");
                if(arrQueue.count == 0) drawArrow(grphcs, 610, 640, 10, "front", "left");
                else drawArrow(grphcs, 610, 615, 10, "front", "left");
                break;
                
            case "llstack":
                grphcs.drawRect(350, 225, 700, 550);
                drawArrow(grphcs, 400, 258, 25, "top", "right");
                newLine = 0;
                for (int i = 1; i <= sizeOfLinkedList; i++) {
                    newLine += ((i)%8 == 0 ? 1 : 0);
                    drawArrow(grphcs, 425 + (i%8)*75, 258 + newLine*100, 25, "", "right");
                }
                for (int i = 0; i < newLine; i++) {
                    drawArrowToNewLine(grphcs, i);
                }
                break;
                
            case "llqueue":
                grphcs.drawRect(350, 225, 700, 550);
                drawArrow(grphcs, 400, 258, 25, "front", "right");
                newLine = 0;
                for (int i = 1; i <= sizeOfLinkedList; i++) {
                    newLine += ((i)%8 == 0 ? 1 : 0);
                    drawArrow(grphcs, 425 + (i%8)*75, 258 + newLine*100, 25, "", "right");
                }
                for (int i = 0; i < newLine; i++) {
                    drawArrowToNewLine(grphcs, i);
                }
                if(sizeOfLinkedList > 0){
                    drawArrow(grphcs, 400 + (sizeOfLinkedList%8)*75, 265 + newLine*100, 25, "rear", "up");
                }
                break;   
                
            default:
                break;
        }
        
    }
    
    void changeButtons(){
        remove(btn1);
        remove(btn2);
        remove(btn3);
        remove(btn4);
        add(btn5);
        add(btnRemove);
        add(btnShow);
        add(btnAdd);
        add(inputTextFiled);
    }
    
    void btn1Action(){
        this.btn1.addActionListener((ActionEvent e) -> {        
            menu = "stack";
            changeButtons();
            repaint();
        });
    }
    
    void btn2Action(){
        this.btn2.addActionListener((ActionEvent e) -> {
            menu = "queue";
            changeButtons();
            repaint();
        });
    }
    
    void btn3Action(){
        this.btn3.addActionListener((ActionEvent e) -> {
            menu = "llstack";
            changeButtons();
            repaint();
        });
    }
    
    void btn4Action(){
        this.btn4.addActionListener((ActionEvent e) -> {
            menu = "llqueue";
            changeButtons();
            repaint();
        });
    }
    
    void btn5Action(){
        this.btn5.addActionListener((ActionEvent e) -> {
            menu = "main";
            add(btn1);
            add(btn2);
            add(btn3);
            add(btn4);
            remove(btn5);
            remove(btnRemove);
            remove(btnShow);
            remove(btnAdd);
            remove(inputTextFiled);
            for (Label labelOfArrayQueue : labelsOfArrayQueue) {
                remove(labelOfArrayQueue);
            }
            for (Button buttonOfArrayQueue : buttonsOfArrayQueue) {
                remove(buttonOfArrayQueue);
            }
            for (Button buttonOfLinkedList : buttonsOfLinkedList) {
                sizeOfLinkedList = 0;
                remove(buttonOfLinkedList);
            }
            lls = new LLStack();
            llq = new LLQueue();
            repaint();
        });
    }
    
    void btnAddAction(){
        this.btnAdd.addActionListener((ActionEvent e) -> {
            switch (menu){
                case "stack":
                    arrStack.push(Integer.parseInt(inputTextFiled.getText()));
                    labelsOfArrayQueue[arrStack.index].setText(""+arrStack.peek());
                    repaint();
                    break;
                    
                case "queue":
                    arrQueue.add(Integer.parseInt(inputTextFiled.getText()));
                    buttonsOfArrayQueue[arrQueue.count-1].setLabel(inputTextFiled.getText());
                    repaint();
                    break;
                    
                case "llstack":
                    add(buttonsOfLinkedList[sizeOfLinkedList]);
                    LLQueue shiftRight = new LLQueue();
                    for (int i = 0; i < sizeOfLinkedList; i++) {
                        shiftRight.push(Integer.parseInt(buttonsOfLinkedList[i].getLabel()));
                    }
                    for (int i = 1; i <= sizeOfLinkedList; i++) {
                        buttonsOfLinkedList[i].setLabel(""+shiftRight.dequeue());
                    }
                    buttonsOfLinkedList[0].setLabel(inputTextFiled.getText());
                    lls.push(Integer.parseInt(inputTextFiled.getText()));                           
                    sizeOfLinkedList++;
                    repaint();
                    break;
                    
                case "llqueue":
                    add(buttonsOfLinkedList[sizeOfLinkedList]);
                    buttonsOfLinkedList[sizeOfLinkedList].setLabel(inputTextFiled.getText());
                    llq.push(Integer.parseInt(inputTextFiled.getText()));
                    sizeOfLinkedList++;
                    repaint();
                    break;
                    
                default:
            }
        });
    }
    
    void btnRemoveAction(){
        this.btnRemove.addActionListener((ActionEvent e) -> {
            switch (menu){
                case "stack":
                    inputTextFiled.setText(""+arrStack.pop());
                    repaint();
                    break;
                    
                case "queue":
                    inputTextFiled.setText(""+arrQueue.remove());
                    for (int i = 0; i < arrQueue.count; i++) {
                        buttonsOfArrayQueue[i].setLabel(buttonsOfArrayQueue[i+1].getLabel());
                    }
                    buttonsOfArrayQueue[arrQueue.count].setLabel("");
                    repaint();
                    break;
                    
                case "llstack":
                    if(sizeOfLinkedList > 0){
                        inputTextFiled.setText(""+lls.pop());
                        for (int i = 0; i < sizeOfLinkedList; i++) {
                            buttonsOfLinkedList[i].setLabel(buttonsOfLinkedList[i+1].getLabel());
                        }
                        remove(buttonsOfLinkedList[--sizeOfLinkedList]);
                        repaint();
                    }
                    break;
                    
                case "llqueue":
                    if(sizeOfLinkedList > 0){
                        inputTextFiled.setText(""+llq.dequeue());
                        for (int i = 0; i < sizeOfLinkedList; i++) {
                            buttonsOfLinkedList[i].setLabel(buttonsOfLinkedList[i+1].getLabel());
                        }
                        remove(buttonsOfLinkedList[--sizeOfLinkedList]);
                        repaint();
                    }
                    break;
                    
                default:
            }
        });
    }
    
    void btnShowAction(){
        this.btnShow.addActionListener((ActionEvent e) -> {
            switch (menu){
                case "stack":
                    inputTextFiled.setText(""+arrStack.peek());
                    break;
                    
                case "queue":
                    inputTextFiled.setText(""+arrQueue.peek());
                    break;
                    
                case "llstack":
                    inputTextFiled.setText(""+lls.peek());
                    break;
                    
                case "llqueue":
                    inputTextFiled.setText(""+llq.peek());
                    break;
                    
                default:
            }
        });
    }
    
    void drawArrow(Graphics grphcs, int x, int y, int length, String s, String direction){
        switch (direction){
            case "left":
                grphcs.drawLine(x, y, x + length, y);
                grphcs.drawLine(x, y, x + 3, y + 3);
                grphcs.drawLine(x, y, x + 3, y - 3);
                grphcs.drawString(s, x+length+5, y);
                break;
            case "right":
                grphcs.drawLine(x, y, x + length, y);
                grphcs.drawLine(x + length, y, x + length - 3, y + 3);
                grphcs.drawLine(x + length, y, x + length - 3, y - 3);
                grphcs.drawString(s, x - s.length()*7, y);
                break;
            case "up":
                grphcs.drawLine(x, y, x, y + length);
                grphcs.drawLine(x, y, x + 3, y + 3);
                grphcs.drawLine(x, y, x -3, y + 3);
                grphcs.drawString(s, x - (s.length()/2)*7, y+length+15);
                break;
            case "down":
                grphcs.drawLine(x, y, x, y + length);
                grphcs.drawLine(x, y + length, x + 3, y + length - 3);
                grphcs.drawLine(x, y + length, x -3, y + length - 3);
                grphcs.drawString(s, x - (s.length()/2)*7, y-5);
                break;
        }
    }
    
    void drawArrowToNewLine(Graphics grphcs, int line){
        drawArrow(grphcs, 975, 258 + line*100, 50, "", "down");
        drawArrow(grphcs, 400, 308 + line*100, 575, "", "left");
        drawArrow(grphcs, 400, 308 + line*100, 35, "", "down");
    }
    
    
}
