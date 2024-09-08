import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class Formula1GUI extends JFrame implements ActionListener{

    private ArrayList<Formula1Driver> formula1DriverList;
    private ArrayList<Race> raceList;
    private LocalDate raceDate;

    private JLabel positionLabel;
    private JLabel driverNameLabel;
    private JLabel driverLocLabel;
    private JLabel teamNameLabel;
    private JLabel noOfRacesLabel;
    private JLabel noOf1stPlaceLabel;
    private JLabel currentPointLabel;
    private JLabel headingLabel;
    private JLabel placeLabel;
    private JLabel startingPositionLabel;
    private JLabel raceNameLabel;
    private JLabel raceDateLabel;

    private JLabel yearLabel;
    private JLabel monthLabel;
    private JLabel dateLabel;

    //This will be used to create all the JPanels.
    private JPanel panel;

    private JButton ascBtn;
    private JButton dscBtn;
    private JButton most1PosBtn;
    private JButton randomRaceBtn;
    private JButton positionRaceBtn;
    private JButton backBtn;
    private JButton randomRaceNext;
    private JButton positionRaceNext;
    private JButton ascRaceDateBtn;
    private JButton searchDriverBtn;
    private JButton driverSearchNext;
    private JButton randomRetryBtn;
    private JButton positionRetryBtn;

    private JTextField yearTF;
    private JTextField monthTF;
    private JTextField dateTF;
    private JTextField raceNameTF;
    private JTextField driverSearchNameTF;


    //To keep the references to all the panels so can be deleted easily.
    private ArrayList<JPanel> jPanelContainer = new ArrayList<>();

    public Formula1GUI(ArrayList<Formula1Driver> formula1DriverList, ArrayList<Race> raceList){

        this.formula1DriverList = formula1DriverList;
        this.raceList = raceList;

        //To set the Frame Properties.
        setFrameProperties();

        //To start the GUI with the heading and the descending order points list.
        headingGUI();
        displayStatisticsDescOrder();

    }

    private void setFrameProperties(){

        this.setTitle("F1Championship GUI");
        this.setSize(1200,830);
        //this.getContentPane().setBackground(Color.black);

        //this will close and dispose the frame but the program will be still Running.
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //This will bring the Frame to the Center position to the Screen.
        this.setLocationRelativeTo(null);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == ascBtn){

            displayStatisticsAsceOrder();

        }else if(e.getSource() == dscBtn){

            displayStatisticsDescOrder();

        }else if(e.getSource() == most1PosBtn){

            displayStatisticsMost1Place();

        }else if(e.getSource() == randomRaceBtn){

            randomRaceDate();

        }else if(e.getSource() == backBtn){

            headingGUI();
            displayStatisticsDescOrder();

        }else if(e.getSource() == positionRaceBtn){

            positionRaceDate();

        }else if(e.getSource() == randomRaceNext){

            randomRaceDateValidate();

        }else if(e.getSource() == positionRaceNext){

            positionRaceDateValidate();

        }else if(e.getSource() == ascRaceDateBtn){

            displayAsceDateRace();

        }else if(e.getSource() == searchDriverBtn){


            searchDriverMenu();

        }else if(e.getSource() == driverSearchNext){

            displayDriverDetails();

        }else if(e.getSource() == randomRetryBtn){

            randomRaceDate();

        }else if(e.getSource() == positionRetryBtn){

            positionRaceDate();

        }
    }


    public void headingGUI(){

        //..................To Have The Heading....................
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,50));
        this.panel.setBackground(Color.ORANGE);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,13));

        //To display the position.
        positionLabel = new JLabel("Position", SwingConstants.CENTER);
        positionLabel.setPreferredSize(new Dimension(100,20));
        positionLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
        positionLabel.setBorder(new LineBorder(Color.black));

        //To display the Driver Name.
        driverNameLabel = new JLabel("DriverName", SwingConstants.CENTER);
        driverNameLabel.setPreferredSize(new Dimension(100,20));
        driverNameLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
        driverNameLabel.setBorder(new LineBorder(Color.black));

        //To display the Driver Location.
        driverLocLabel = new JLabel("Location", SwingConstants.CENTER);
        driverLocLabel.setPreferredSize(new Dimension(100,20));
        driverLocLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
        driverLocLabel.setBorder(new LineBorder(Color.black));

        //To display the Team Name.
        teamNameLabel = new JLabel("ConstructorTeam", SwingConstants.CENTER);
        teamNameLabel.setPreferredSize(new Dimension(140,20));
        teamNameLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
        teamNameLabel.setBorder(new LineBorder(Color.black));

        //To display the No Of Races participated.
        noOfRacesLabel = new JLabel("NoOFRaces", SwingConstants.CENTER);
        noOfRacesLabel.setPreferredSize(new Dimension(100,20));
        noOfRacesLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
        noOfRacesLabel.setBorder(new LineBorder(Color.black));

        //To display the No of 1st Position.
        noOf1stPlaceLabel = new JLabel("NoOf 1st Places", SwingConstants.CENTER);
        noOf1stPlaceLabel.setPreferredSize(new Dimension(130,20));
        noOf1stPlaceLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
        noOf1stPlaceLabel.setBorder(new LineBorder(Color.black));

        //To display the Current Points
        currentPointLabel = new JLabel("CurrentPoints", SwingConstants.CENTER);
        currentPointLabel.setPreferredSize(new Dimension(120,20));
        currentPointLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
        currentPointLabel.setBorder(new LineBorder(Color.black));

        //Adding the labels to the panel1.
        this.panel.add(positionLabel);
        this.panel.add(driverNameLabel);
        this.panel.add(driverLocLabel);
        this.panel.add(teamNameLabel);
        this.panel.add(noOfRacesLabel);
        this.panel.add(noOf1stPlaceLabel);
        this.panel.add(currentPointLabel);

        //adding the panel to the Frame.
        add(this.panel);
        //To Add the Panel to the jPanelContainer
        this.jPanelContainer.add(this.panel);

    }

    public void displayStatisticsDescOrder(){

        //removing all the previous panels
        for (JPanel panel : jPanelContainer) {
            remove(panel);
        }
        //Clearing the container So it can hold the next values...
        jPanelContainer.clear();

        //This will Create the Heading.
        headingGUI();

        //Sorting things starts here...
        int sizeArraylist = formula1DriverList.size();

        //copying and storing it in the arrays to make the execution even faster.
        Formula1Driver[] sortedRacers = new Formula1Driver[sizeArraylist];

        for (int i = 0; i < sortedRacers.length; i++)
        {
            sortedRacers[i] = formula1DriverList.get(i);
        }

        //To hold Temporary Driver.
        Formula1Driver temporaryDriver;

        for (int i = 0; i < sortedRacers.length; i++) {
            for (int j = i + 1; j < sortedRacers.length; j++)
            {
                if (sortedRacers[i].getCurrentPoints() < sortedRacers[j].getCurrentPoints()) {
                    temporaryDriver = sortedRacers[i];
                    sortedRacers[i] = sortedRacers[j];
                    sortedRacers[j] = temporaryDriver;
                }else if (sortedRacers[i].getCurrentPoints() == sortedRacers[j].getCurrentPoints()){

                    int timesI = 0;
                    if (sortedRacers[i].getStatistics().get(1) != null){
                        timesI = sortedRacers[i].getStatistics().get(1);
                    }


                    int timesJ = 0;
                    if (sortedRacers[j].getStatistics().get(1) != null){
                        timesJ = sortedRacers[j].getStatistics().get(1);
                    }

                    if(timesI < timesJ){
                        temporaryDriver = sortedRacers[i];
                        sortedRacers[i] = sortedRacers[j];
                        sortedRacers[j] = temporaryDriver;
                    }
                }
            }
        }


        //To display all the Drivers in sortedRacers Array who had been sorted according to their points in Descending order.
        for(int i = 0; i < sortedRacers.length; i++){

            //for the panel which is responsible to add all the drivers one by one from the sortedArray.
            this.panel = new JPanel();
            this.panel.setPreferredSize(new Dimension(1150,25));
            this.panel.setBackground(Color.PINK);
            this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,2));


            String teamName;
            if(sortedRacers[i].getTeam() != null) {
                teamName = sortedRacers[i].getTeam().getTeamName();
            }else{
                teamName = "Not Assigned Yet";
            }


            int timesOfPosition1 = 0;
            if (sortedRacers[i].getStatistics().get(1) != null){
                timesOfPosition1 = sortedRacers[i].getStatistics().get(1);
            }

            positionLabel = new JLabel(i+1 + "", SwingConstants.CENTER);
            positionLabel.setPreferredSize(new Dimension(100,20));
            positionLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
            positionLabel.setBorder(new LineBorder(Color.black));

            driverNameLabel = new JLabel(sortedRacers[i].getDriverName(), SwingConstants.CENTER);
            driverNameLabel.setPreferredSize(new Dimension(100,20));
            driverNameLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
            driverNameLabel.setBorder(new LineBorder(Color.black));

            driverLocLabel = new JLabel(sortedRacers[i].getDriverLocation(), SwingConstants.CENTER);
            driverLocLabel.setPreferredSize(new Dimension(100,20));
            driverLocLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
            driverLocLabel.setBorder(new LineBorder(Color.black));

            teamNameLabel = new JLabel(teamName, SwingConstants.CENTER);
            teamNameLabel.setPreferredSize(new Dimension(140,20));
            teamNameLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
            teamNameLabel.setBorder(new LineBorder(Color.black));

            noOfRacesLabel = new JLabel(sortedRacers[i].getNoOfRaces() + "", SwingConstants.CENTER);
            noOfRacesLabel.setPreferredSize(new Dimension(100,20));
            noOfRacesLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
            noOfRacesLabel.setBorder(new LineBorder(Color.black));

            noOf1stPlaceLabel = new JLabel(timesOfPosition1 + "", SwingConstants.CENTER);
            noOf1stPlaceLabel.setPreferredSize(new Dimension(130,20));
            noOf1stPlaceLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
            noOf1stPlaceLabel.setBorder(new LineBorder(Color.black));

            currentPointLabel = new JLabel(sortedRacers[i].getCurrentPoints() + "", SwingConstants.CENTER);
            currentPointLabel.setPreferredSize(new Dimension(120,20));
            currentPointLabel.setFont(new Font(positionLabel.getFont().getName(),positionLabel.getFont().getStyle(),15));
            currentPointLabel.setBorder(new LineBorder(Color.black));

            //adding all the labels to the Panel2.
            this.panel.add(positionLabel);
            this.panel.add(driverNameLabel);
            this.panel.add(driverLocLabel);
            this.panel.add(teamNameLabel);
            this.panel.add(noOfRacesLabel);
            this.panel.add(noOf1stPlaceLabel);
            this.panel.add(currentPointLabel);

            //adding panel to the Frame.
            add(this.panel);
            //To store the panels in the container so can remove when necessary.
            jPanelContainer.add(this.panel);

        }



        //panel to hold the buttons which only responsible for arranging Stuffs.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,60));
        this.panel.setBackground(Color.DARK_GRAY);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,15));

        ascBtn = new JButton("Ascending Order");
        ascBtn.setPreferredSize(new Dimension(150,30));
        ascBtn.setBackground(new Color(100, 150, 10));
        ascBtn.setForeground(Color.white);
        ascBtn.setFocusPainted(false);
        ascBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        ascBtn.setBorder(new LineBorder(Color.black));
        ascBtn.addActionListener(this);
        this.panel.add(ascBtn);

        most1PosBtn = new JButton("Most 1 Pos Order");
        most1PosBtn.setPreferredSize(new Dimension(150,30));
        most1PosBtn.setBackground(new Color(100, 150, 10));
        most1PosBtn.setForeground(Color.white);
        most1PosBtn.setFocusPainted(false);
        most1PosBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        most1PosBtn.setBorder(new LineBorder(Color.black));
        most1PosBtn.addActionListener(this);
        this.panel.add(most1PosBtn);

        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        //panel to hold the buttons which is responsible to race actions.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,60));
        this.panel.setBackground(Color.LIGHT_GRAY);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,15));

        randomRaceBtn = new JButton("Random Race");
        randomRaceBtn.setPreferredSize(new Dimension(150,30));
        randomRaceBtn.setBackground(new Color(40, 80, 100));
        randomRaceBtn.setForeground(Color.white);
        randomRaceBtn.setFocusPainted(false);
        randomRaceBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        randomRaceBtn.setBorder(new LineBorder(Color.black));
        randomRaceBtn.addActionListener(this);
        this.panel.add(randomRaceBtn);

        positionRaceBtn = new JButton("Position Race");
        positionRaceBtn.setPreferredSize(new Dimension(150,30));
        positionRaceBtn.setBackground(new Color(40, 80, 100));
        positionRaceBtn.setForeground(Color.white);
        positionRaceBtn.setFocusPainted(false);
        positionRaceBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        positionRaceBtn.setBorder(new LineBorder(Color.black));
        positionRaceBtn.addActionListener(this);
        this.panel.add(positionRaceBtn);

        ascRaceDateBtn = new JButton("Ascending Date Race");
        ascRaceDateBtn.setPreferredSize(new Dimension(200,30));
        ascRaceDateBtn.setBackground(new Color(40, 80, 100));
        ascRaceDateBtn.setForeground(Color.white);
        ascRaceDateBtn.setFocusPainted(false);
        ascRaceDateBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        ascRaceDateBtn.setBorder(new LineBorder(Color.black));
        ascRaceDateBtn.addActionListener(this);
        this.panel.add(ascRaceDateBtn);

        searchDriverBtn = new JButton("Search Driver");
        searchDriverBtn.setPreferredSize(new Dimension(150,30));
        searchDriverBtn.setBackground(new Color(40, 80, 100));
        searchDriverBtn.setForeground(Color.white);
        searchDriverBtn.setFocusPainted(false);
        searchDriverBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        searchDriverBtn.setBorder(new LineBorder(Color.black));
        searchDriverBtn.addActionListener(this);
        this.panel.add(searchDriverBtn);

        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        //This will help you to refresh the Frame Once the changes have been made.
        revalidate();
        repaint();
    }


    private void displayStatisticsAsceOrder() {

        //removing all the previous panels
        for (JPanel panel : jPanelContainer) {
            remove(panel);
        }
        //Clearing the container So it can hold the next values...
        jPanelContainer.clear();

        //This will Create the Heading.
        headingGUI();

        int sizeArraylist = formula1DriverList.size();

        //copying and storing it in the arrays to make the execution even faster.
        Formula1Driver[] sortedRacers = new Formula1Driver[sizeArraylist];

        for (int i = 0; i < sortedRacers.length; i++) {
            sortedRacers[i] = formula1DriverList.get(i);
        }

        //To hold Temporary Driver.
        Formula1Driver temporaryDriver;

        //Responsible to arrange the points in Ascending order.
        for (int i = 0; i < sortedRacers.length; i++) {
            for (int j = i + 1; j < sortedRacers.length; j++) {
                if (sortedRacers[i].getCurrentPoints() > sortedRacers[j].getCurrentPoints()) {
                    temporaryDriver = sortedRacers[i];
                    sortedRacers[i] = sortedRacers[j];
                    sortedRacers[j] = temporaryDriver;

                    //If they got the Same point the driver who won the most 1 st places will be go low of the order.
                } else if (sortedRacers[i].getCurrentPoints() == sortedRacers[j].getCurrentPoints()) {

                    int timesI = 0;
                    if (sortedRacers[i].getStatistics().get(1) != null) {
                        timesI = sortedRacers[i].getStatistics().get(1);
                    }

                    int timesJ = 0;
                    if (sortedRacers[j].getStatistics().get(1) != null) {
                        timesJ = sortedRacers[j].getStatistics().get(1);
                    }

                    if (timesI > timesJ) {
                        temporaryDriver = sortedRacers[i];
                        sortedRacers[i] = sortedRacers[j];
                        sortedRacers[j] = temporaryDriver;
                    }
                }
            }
        }


        //To display all the Drivers in sortedRacers Array who had been sorted according to their points in Ascending order.
        for (int i = 0; i < sortedRacers.length; i++) {

            //for the panel which is responsible to add all the drivers one by one from the sortedArray.
            this.panel = new JPanel();
            this.panel.setPreferredSize(new Dimension(1150,25));
            this.panel.setBackground(Color.PINK);
            this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,2));

            String teamName;
            if (sortedRacers[i].getTeam() != null) {
                teamName = sortedRacers[i].getTeam().getTeamName();
            } else {
                teamName = "Not Assigned Yet";
            }


            int timesOfPosition1 = 0;
            if (sortedRacers[i].getStatistics().get(1) != null) {
                timesOfPosition1 = sortedRacers[i].getStatistics().get(1);
            }

            positionLabel = new JLabel(i + 1 + "", SwingConstants.CENTER);
            positionLabel.setPreferredSize(new Dimension(100, 20));
            positionLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            positionLabel.setBorder(new LineBorder(Color.black));

            driverNameLabel = new JLabel(sortedRacers[i].getDriverName(), SwingConstants.CENTER);
            driverNameLabel.setPreferredSize(new Dimension(100, 20));
            driverNameLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            driverNameLabel.setBorder(new LineBorder(Color.black));

            driverLocLabel = new JLabel(sortedRacers[i].getDriverLocation(), SwingConstants.CENTER);
            driverLocLabel.setPreferredSize(new Dimension(100, 20));
            driverLocLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            driverLocLabel.setBorder(new LineBorder(Color.black));

            teamNameLabel = new JLabel(teamName, SwingConstants.CENTER);
            teamNameLabel.setPreferredSize(new Dimension(140, 20));
            teamNameLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            teamNameLabel.setBorder(new LineBorder(Color.black));

            noOfRacesLabel = new JLabel(sortedRacers[i].getNoOfRaces() + "", SwingConstants.CENTER);
            noOfRacesLabel.setPreferredSize(new Dimension(100, 20));
            noOfRacesLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            noOfRacesLabel.setBorder(new LineBorder(Color.black));

            noOf1stPlaceLabel = new JLabel(timesOfPosition1 + "", SwingConstants.CENTER);
            noOf1stPlaceLabel.setPreferredSize(new Dimension(130, 20));
            noOf1stPlaceLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            noOf1stPlaceLabel.setBorder(new LineBorder(Color.black));

            currentPointLabel = new JLabel(sortedRacers[i].getCurrentPoints() + "", SwingConstants.CENTER);
            currentPointLabel.setPreferredSize(new Dimension(120, 20));
            currentPointLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            currentPointLabel.setBorder(new LineBorder(Color.black));

            //adding all the labels to the Panel.
            this.panel.add(positionLabel);
            this.panel.add(driverNameLabel);
            this.panel.add(driverLocLabel);
            this.panel.add(teamNameLabel);
            this.panel.add(noOfRacesLabel);
            this.panel.add(noOf1stPlaceLabel);
            this.panel.add(currentPointLabel);

            //adding panel to the Frame.
            add(this.panel);
            //To store the panels in the container so can remove when necessary.
            jPanelContainer.add(this.panel);

        }

        //panel to hold the buttons which only responsible for arranging stuffs.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,60));
        this.panel.setBackground(Color.DARK_GRAY);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,15));

        dscBtn = new JButton("Descending Order");
        dscBtn.setPreferredSize(new Dimension(150,30));
        dscBtn.setBackground(new Color(100, 150, 10));
        dscBtn.setForeground(Color.white);
        dscBtn.setFocusPainted(false);
        dscBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        dscBtn.setBorder(new LineBorder(Color.black));
        dscBtn.addActionListener(this);
        this.panel.add(dscBtn);

        most1PosBtn = new JButton("Most 1 Pos Order");
        most1PosBtn.setPreferredSize(new Dimension(150,30));
        most1PosBtn.setBackground(new Color(100, 150, 10));
        most1PosBtn.setForeground(Color.white);
        most1PosBtn.setFocusPainted(false);
        most1PosBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        most1PosBtn.setBorder(new LineBorder(Color.black));
        most1PosBtn.addActionListener(this);
        this.panel.add(most1PosBtn);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        //panel to hold the buttons which is responsible to race actions.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,60));
        this.panel.setBackground(Color.LIGHT_GRAY);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,15));

        randomRaceBtn = new JButton("Random Race");
        randomRaceBtn.setPreferredSize(new Dimension(150,30));
        randomRaceBtn.setBackground(new Color(40, 80, 100));
        randomRaceBtn.setForeground(Color.white);
        randomRaceBtn.setFocusPainted(false);
        randomRaceBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        randomRaceBtn.setBorder(new LineBorder(Color.black));
        randomRaceBtn.addActionListener(this);
        this.panel.add(randomRaceBtn);

        positionRaceBtn = new JButton("Position Race");
        positionRaceBtn.setPreferredSize(new Dimension(150,30));
        positionRaceBtn.setBackground(new Color(40, 80, 100));
        positionRaceBtn.setForeground(Color.white);
        positionRaceBtn.setFocusPainted(false);
        positionRaceBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        positionRaceBtn.setBorder(new LineBorder(Color.black));
        positionRaceBtn.addActionListener(this);
        this.panel.add(positionRaceBtn);

        ascRaceDateBtn = new JButton("Ascending Date Race");
        ascRaceDateBtn.setPreferredSize(new Dimension(200,30));
        ascRaceDateBtn.setBackground(new Color(40, 80, 100));
        ascRaceDateBtn.setForeground(Color.white);
        ascRaceDateBtn.setFocusPainted(false);
        ascRaceDateBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        ascRaceDateBtn.setBorder(new LineBorder(Color.black));
        ascRaceDateBtn.addActionListener(this);
        this.panel.add(ascRaceDateBtn);

        searchDriverBtn = new JButton("Search Driver");
        searchDriverBtn.setPreferredSize(new Dimension(150,30));
        searchDriverBtn.setBackground(new Color(40, 80, 100));
        searchDriverBtn.setForeground(Color.white);
        searchDriverBtn.setFocusPainted(false);
        searchDriverBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        searchDriverBtn.setBorder(new LineBorder(Color.black));
        searchDriverBtn.addActionListener(this);
        this.panel.add(searchDriverBtn);


        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        //This will help you to refresh the Frame Once the changes have been made.
        revalidate();
        repaint();
    }

    private void displayStatisticsMost1Place() {

        //removing all the previous panels
        for (JPanel panel : jPanelContainer) {
            remove(panel);
        }
        //Clearing the container So it can hold the next values...
        jPanelContainer.clear();

        //This will Create the Heading.
        headingGUI();

        //Sorting things starts here...
        int sizeArraylist = formula1DriverList.size();

        //copying and storing it in the arrays to make the execution even faster.
        Formula1Driver[] sortedRacers = new Formula1Driver[sizeArraylist];

        for (int i = 0; i < sortedRacers.length; i++)
        {
            sortedRacers[i] = formula1DriverList.get(i);
        }


        //To hold Temporary Driver.
        Formula1Driver temporaryDriver;

        //For sorting according to the Most1Places.
        for (int i = 0; i < sortedRacers.length; i++){
            for(int j = i + 1; j < sortedRacers.length; j++){

                int timesI = 0;
                if (sortedRacers[i].getStatistics().get(1) != null){
                    timesI = sortedRacers[i].getStatistics().get(1);
                }


                int timesJ = 0;
                if (sortedRacers[j].getStatistics().get(1) != null){
                    timesJ = sortedRacers[j].getStatistics().get(1);
                }

                if(timesI < timesJ){
                    temporaryDriver = sortedRacers[i];
                    sortedRacers[i] = sortedRacers[j];
                    sortedRacers[j] = temporaryDriver;

                    //if the times are equal the driver with the most points will be at the top -> Extra work
                } else if (timesI == timesJ){
                    if (sortedRacers[i].getCurrentPoints() < sortedRacers[j].getCurrentPoints()) {
                        temporaryDriver = sortedRacers[i];
                        sortedRacers[i] = sortedRacers[j];
                        sortedRacers[j] = temporaryDriver;
                    }
                }
            }
        }


        //To display all the Drivers in sortedRacers Array who had been sorted according to their points in Most 1st Position order.
        for (int i = 0; i < sortedRacers.length; i++) {

            //for the panel which is responsible to add all the drivers one by one from the sortedArray.
            this.panel = new JPanel();
            this.panel.setPreferredSize(new Dimension(1150,25));
            this.panel.setBackground(Color.PINK);
            this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,2));

            String teamName;
            if (sortedRacers[i].getTeam() != null) {
                teamName = sortedRacers[i].getTeam().getTeamName();
            } else {
                teamName = "Not Assigned Yet";
            }


            int timesOfPosition1 = 0;
            if (sortedRacers[i].getStatistics().get(1) != null) {
                timesOfPosition1 = sortedRacers[i].getStatistics().get(1);
            }

            positionLabel = new JLabel(i + 1 + "", SwingConstants.CENTER);
            positionLabel.setPreferredSize(new Dimension(100, 20));
            positionLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            positionLabel.setBorder(new LineBorder(Color.black));

            driverNameLabel = new JLabel(sortedRacers[i].getDriverName(), SwingConstants.CENTER);
            driverNameLabel.setPreferredSize(new Dimension(100, 20));
            driverNameLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            driverNameLabel.setBorder(new LineBorder(Color.black));

            driverLocLabel = new JLabel(sortedRacers[i].getDriverLocation(), SwingConstants.CENTER);
            driverLocLabel.setPreferredSize(new Dimension(100, 20));
            driverLocLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            driverLocLabel.setBorder(new LineBorder(Color.black));

            teamNameLabel = new JLabel(teamName, SwingConstants.CENTER);
            teamNameLabel.setPreferredSize(new Dimension(140, 20));
            teamNameLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            teamNameLabel.setBorder(new LineBorder(Color.black));

            noOfRacesLabel = new JLabel(sortedRacers[i].getNoOfRaces() + "", SwingConstants.CENTER);
            noOfRacesLabel.setPreferredSize(new Dimension(100, 20));
            noOfRacesLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            noOfRacesLabel.setBorder(new LineBorder(Color.black));

            noOf1stPlaceLabel = new JLabel(timesOfPosition1 + "", SwingConstants.CENTER);
            noOf1stPlaceLabel.setPreferredSize(new Dimension(130, 20));
            noOf1stPlaceLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            noOf1stPlaceLabel.setBorder(new LineBorder(Color.black));

            currentPointLabel = new JLabel(sortedRacers[i].getCurrentPoints() + "", SwingConstants.CENTER);
            currentPointLabel.setPreferredSize(new Dimension(120, 20));
            currentPointLabel.setFont(new Font(positionLabel.getFont().getName(), positionLabel.getFont().getStyle(), 15));
            currentPointLabel.setBorder(new LineBorder(Color.black));

            //adding all the labels to the Panel.
            this.panel.add(positionLabel);
            this.panel.add(driverNameLabel);
            this.panel.add(driverLocLabel);
            this.panel.add(teamNameLabel);
            this.panel.add(noOfRacesLabel);
            this.panel.add(noOf1stPlaceLabel);
            this.panel.add(currentPointLabel);

            //adding panel to the Frame.
            add(this.panel);
            //To store the panels in the container so can remove when necessary.
            jPanelContainer.add(this.panel);

        }

        //panel to hold the buttons which only responsible for arranging stuffs.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,60));
        this.panel.setBackground(Color.DARK_GRAY);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,15));

        dscBtn = new JButton("Descending Order");
        dscBtn.setPreferredSize(new Dimension(150,30));
        dscBtn.setBackground(new Color(100, 150, 10));
        dscBtn.setForeground(Color.white);
        dscBtn.setFocusPainted(false);
        dscBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        dscBtn.setBorder(new LineBorder(Color.black));
        dscBtn.addActionListener(this);
        this.panel.add(dscBtn);

        ascBtn = new JButton("Ascending Order");
        ascBtn.setPreferredSize(new Dimension(150,30));
        ascBtn.setBackground(new Color(100, 150, 10));
        ascBtn.setForeground(Color.white);
        ascBtn.setFocusPainted(false);
        ascBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        ascBtn.setBorder(new LineBorder(Color.black));
        ascBtn.addActionListener(this);
        this.panel.add(ascBtn);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        //panel to hold the buttons which is responsible to race actions.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,60));
        this.panel.setBackground(Color.LIGHT_GRAY);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,15));

        randomRaceBtn = new JButton("Random Race");
        randomRaceBtn.setPreferredSize(new Dimension(150,30));
        randomRaceBtn.setBackground(new Color(40, 80, 100));
        randomRaceBtn.setForeground(Color.white);
        randomRaceBtn.setFocusPainted(false);
        randomRaceBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        randomRaceBtn.setBorder(new LineBorder(Color.black));
        randomRaceBtn.addActionListener(this);
        this.panel.add(randomRaceBtn);

        positionRaceBtn = new JButton("Position Race");
        positionRaceBtn.setPreferredSize(new Dimension(150,30));
        positionRaceBtn.setBackground(new Color(40, 80, 100));
        positionRaceBtn.setForeground(Color.white);
        positionRaceBtn.setFocusPainted(false);
        positionRaceBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        positionRaceBtn.setBorder(new LineBorder(Color.black));
        positionRaceBtn.addActionListener(this);
        this.panel.add(positionRaceBtn);

        ascRaceDateBtn = new JButton("Ascending Date Race");
        ascRaceDateBtn.setPreferredSize(new Dimension(200,30));
        ascRaceDateBtn.setBackground(new Color(40, 80, 100));
        ascRaceDateBtn.setForeground(Color.white);
        ascRaceDateBtn.setFocusPainted(false);
        ascRaceDateBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        ascRaceDateBtn.setBorder(new LineBorder(Color.black));
        ascRaceDateBtn.addActionListener(this);
        this.panel.add(ascRaceDateBtn);

        searchDriverBtn = new JButton("Search Driver");
        searchDriverBtn.setPreferredSize(new Dimension(150,30));
        searchDriverBtn.setBackground(new Color(40, 80, 100));
        searchDriverBtn.setForeground(Color.white);
        searchDriverBtn.setFocusPainted(false);
        searchDriverBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        searchDriverBtn.setBorder(new LineBorder(Color.black));
        searchDriverBtn.addActionListener(this);
        this.panel.add(searchDriverBtn);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        //This will help you to refresh the Frame Once the changes have been made.
        revalidate();
        repaint();
    }

    private void randomRaceDate(){

        //removing all the previous panels
        for (JPanel panel : jPanelContainer) {
            remove(panel);
        }
        //Clearing the container So it can hold the next values...
        jPanelContainer.clear();

        //creating the heading panel for Race Details.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,55));
        this.panel.setBackground(new Color(0,128,128));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,8));

        //creating the label to hold the heading.
        headingLabel = new JLabel("Race Name & Date Details", SwingConstants.CENTER);
        headingLabel.setPreferredSize(new Dimension(500,30));
        headingLabel.setForeground(Color.white);
        headingLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        //adding headingLabel to the panel.
        this.panel.add(headingLabel);

        //adding panel to the frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,250));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,200));

        raceNameLabel = new JLabel("Race Name : ", SwingConstants.CENTER);
        raceNameLabel.setPreferredSize(new Dimension(300,30));
        raceNameLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        raceNameTF = new JTextField(20);
        raceNameTF.setPreferredSize(new Dimension(100,40));
        raceNameTF.setFont(new Font("Tahoma", Font.BOLD,20));
        raceNameTF.setBackground(Color.LIGHT_GRAY);
        raceNameTF.setForeground(new Color(52, 52, 52));
        raceNameTF.setHorizontalAlignment(SwingConstants.CENTER);
        raceNameTF.setBorder(new LineBorder(Color.black));

        this.panel.add(raceNameLabel);
        this.panel.add(raceNameTF);

        //adding panel to the frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,100));
        this.panel.setBackground(Color.white);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,8,30));

        yearLabel = new JLabel("Year :", SwingConstants.CENTER);
        yearLabel.setPreferredSize(new Dimension(130,30));
        yearLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        monthLabel = new JLabel("Month :", SwingConstants.CENTER);
        monthLabel.setPreferredSize(new Dimension(130,30));
        monthLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        dateLabel = new JLabel("Date :", SwingConstants.CENTER);
        dateLabel.setPreferredSize(new Dimension(130,30));
        dateLabel.setFont(new Font("Tahoma", Font.BOLD,30));


        yearTF = new JTextField(10);
        yearTF.setPreferredSize(new Dimension(100,40));
        yearTF.setFont(new Font("Tahoma", Font.BOLD,20));
        yearTF.setBackground(Color.LIGHT_GRAY);
        yearTF.setForeground(new Color(52, 52, 52));
        yearTF.setHorizontalAlignment(SwingConstants.CENTER);
        yearTF.setBorder(new LineBorder(Color.black));

        monthTF = new JTextField(10);
        monthTF.setPreferredSize(new Dimension(100,40));
        monthTF.setFont(new Font("Tahoma", Font.BOLD,20));
        monthTF.setBackground(Color.LIGHT_GRAY);
        monthTF.setForeground(new Color(52, 52, 52));
        monthTF.setHorizontalAlignment(SwingConstants.CENTER);
        monthTF.setBorder(new LineBorder(Color.black));

        dateTF = new JTextField(10);
        dateTF.setPreferredSize(new Dimension(100,40));
        dateTF.setFont(new Font("Tahoma", Font.BOLD,20));
        dateTF.setBackground(Color.LIGHT_GRAY);
        dateTF.setForeground(new Color(52, 52, 52));
        dateTF.setHorizontalAlignment(SwingConstants.CENTER);
        dateTF.setBorder(new LineBorder(Color.black));

        this.panel.add(yearLabel);
        this.panel.add(yearTF);

        this.panel.add(monthLabel);
        this.panel.add(monthTF);

        this.panel.add(dateLabel);
        this.panel.add(dateTF);

        //adding panel to the frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,60));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,13));

        randomRaceNext = new JButton("NEXT");
        randomRaceNext.setPreferredSize(new Dimension(150,30));
        randomRaceNext.setBackground(new Color(0,128,128));
        randomRaceNext.setForeground(Color.white);
        randomRaceNext.setFocusPainted(false);
        randomRaceNext.setFont(new Font("Tahoma", Font.BOLD, 15));
        randomRaceNext.setBorder(new LineBorder(Color.black));
        randomRaceNext.addActionListener(this);
        this.panel.add(randomRaceNext);


        //adding panel to the frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        //This will help you to refresh the Frame Once the changes have been made.
        revalidate();
        repaint();
    }


    private void randomRaceDateValidate(){

        int yearDuplicate = Integer.parseInt(this.yearTF.getText());
        int monthDuplicate = Integer.parseInt(this.monthTF.getText());
        int dateDuplicate = Integer.parseInt(this.dateTF.getText());

        try {
            //Here setting the race date.
            raceDate = LocalDate.of(yearDuplicate, monthDuplicate, dateDuplicate);
            displayRandomRaceDetails();

            //If the Date is not a valid date showing message like invalid date.
        } catch (Exception e) {

            //removing all the previous panels
            for (JPanel panel : jPanelContainer) {
                remove(panel);
            }
            //Clearing the container So it can hold the next values...
            jPanelContainer.clear();

            //creating the heading panel for Race Details.
            this.panel = new JPanel();
            this.panel.setPreferredSize(new Dimension(1150,400));
            this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,350));
            //panel1.setBorder(new LineBorder(Color.black));

            //creating the label to hold the heading.
            headingLabel = new JLabel("!! InCorrect Value For Date !!", SwingConstants.CENTER);
            headingLabel.setPreferredSize(new Dimension(500,30));
            headingLabel.setForeground(Color.red);
            headingLabel.setFont(new Font("Tahoma", Font.BOLD,30));

            //adding headingLabel to the panel.
            this.panel.add(headingLabel);

            //adding panel to the frame.
            add(this.panel);
            //To store the panels in the container so can remove when necessary.
            jPanelContainer.add(this.panel);


            this.panel = new JPanel();
            this.panel.setPreferredSize(new Dimension(1150,40));
            //panel3Button.setBackground(Color.white);
            this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,4));

            randomRetryBtn = new JButton("Retry");
            randomRetryBtn.setPreferredSize(new Dimension(150,30));
            randomRetryBtn.setBackground(Color.red);
            randomRetryBtn.setForeground(Color.WHITE);
            randomRetryBtn.setFocusPainted(false);
            randomRetryBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
            randomRetryBtn.setBorder(new LineBorder(Color.black));
            randomRetryBtn.addActionListener(this);
            this.panel.add(randomRetryBtn);


            //adding panel to the Frame.
            add(this.panel);
            //To store the panels in the container so can remove when necessary.
            jPanelContainer.add(this.panel);

            //This will help you to refresh the Frame Once the changes have been made.
            revalidate();
            repaint();

        }

    }

    private void displayRandomRaceDetails() {

        //removing all the previous panels
        for (JPanel panel : jPanelContainer) {
            remove(panel);
        }
        //Clearing the container So it can hold the next values...
        jPanelContainer.clear();

        //getting the raceName
        String raceNameDuplicate = this.raceNameTF.getText();

        //creating the heading panel for Race Details.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,55));
        this.panel.setBackground(Color.ORANGE);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,8));

        //creating the label to hold the heading.
        headingLabel = new JLabel("Random Race " + "\"" + raceNameDuplicate + "\"" + " Details", SwingConstants.CENTER);
        headingLabel.setPreferredSize(new Dimension(1150,30));
        headingLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        //adding headingLabel to the panel.
        this.panel.add(headingLabel);

        //adding panel to the frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        //Creating the panel to hold the Date of the race.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,40));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));

        raceDateLabel = new JLabel("Race Date  : ", SwingConstants.RIGHT);
        raceDateLabel.setPreferredSize(new Dimension(200,25));
        raceDateLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        raceDateLabel.setForeground(Color.red);
        //driverNameLabel.setBorder(new LineBorder(new Color(47,79,79)));

        dateLabel = new JLabel(raceDate + "", SwingConstants.LEFT);
        dateLabel.setPreferredSize(new Dimension(200,25));
        dateLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        dateLabel.setForeground(Color.red);
        //placeLabel.setBorder(new LineBorder(new Color(47,79,79)));

        this.panel.add(raceDateLabel);
        this.panel.add(dateLabel);

        //adding panel to the frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        //Creating the panel to hold the subheadings.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,40));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,10));

        driverNameLabel = new JLabel("Driver Name", SwingConstants.CENTER);
        driverNameLabel.setPreferredSize(new Dimension(200,25));
        driverNameLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        driverNameLabel.setForeground(new Color(47,79,79));
        driverNameLabel.setBorder(new LineBorder(new Color(47,79,79)));

        placeLabel = new JLabel("Place", SwingConstants.CENTER);
        placeLabel.setPreferredSize(new Dimension(200,25));
        placeLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        placeLabel.setForeground(new Color(47,79,79));
        placeLabel.setBorder(new LineBorder(new Color(47,79,79)));

        this.panel.add(driverNameLabel);
        this.panel.add(placeLabel);

        //adding panel to the frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        //Counting how many drivers participating in the race...
        int count = 0;
        for(Formula1Driver driver : formula1DriverList){
            if (driver.getTeam() != null) {
                count = count + 1;
            }
        }

        //To stop the position overridden...
        ArrayList<Integer> positionList = new ArrayList<>();

        //To store the raceDetails like Position and the Driver who got that Position.
        HashMap<Integer, String> raceDetails = new HashMap<>();

        //To create Random values/positions for the driver.
        Random random = new Random();

        int position;

        for (Formula1Driver driver : formula1DriverList) {

            //Race is only for the drivers who have a Team.
            if (driver.getTeam() != null) {

                while (true) {

                    position = 1 + random.nextInt(count);

                    int index = positionList.indexOf(position);

                    //checking that the position is not being overridden. getting every time a different position
                    if (index == -1) {

                        positionList.add(position);

                        //changing the statistics of the driver.
                        int value;
                        if (driver.getStatistics().get(position) != null) {
                            value = driver.getStatistics().get(position);
                            value = value + 1;
                        } else {
                            value = 1;
                        }
                        driver.updateStatistics(position, value);
                        driver.calculatePointsAndNoOfRaces();
                        break;
                    }
                }

                //save all the driver details in the hashmap position and their names.
                raceDetails.put(position, driver.getDriverName());


                //GUI stuffs comes here.

                //JPanel responsible to add the driver race details.
                this.panel = new JPanel();
                this.panel.setPreferredSize(new Dimension(1150,27));
                this.panel.setBackground(Color.white);
                this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,3));

                //label to store the driverName.
                driverNameLabel = new JLabel(driver.getDriverName(), SwingConstants.CENTER);
                driverNameLabel.setPreferredSize(new Dimension(200,20));
                driverNameLabel.setFont(new Font("Tahoma", Font.BOLD,20));
                driverNameLabel.setBorder(new LineBorder(Color.black));

                //label to hold the random position achieve by the drivers.
                placeLabel = new JLabel(position + "", SwingConstants.CENTER);
                placeLabel.setPreferredSize(new Dimension(200,20));
                placeLabel.setFont(new Font("Tahoma", Font.BOLD,20));
                placeLabel.setBorder(new LineBorder(Color.black));

                //adding labels to the panel.
                this.panel.add(driverNameLabel);
                this.panel.add(placeLabel);

                //adding panel to the Frame.
                add(this.panel);
                //To store the panels in the container so can remove when necessary.
                jPanelContainer.add(this.panel);

            }
        }

        //adding the race to the raceList in order maintain all the details of a race.
        raceList.add(new Race(raceNameDuplicate, raceDate, raceDetails));


        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,40));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,4));

        backBtn = new JButton("BACK");
        backBtn.setPreferredSize(new Dimension(150,30));
        backBtn.setBackground(new Color(100, 150, 10));
        backBtn.setForeground(Color.white);
        backBtn.setFocusPainted(false);
        backBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        backBtn.setBorder(new LineBorder(Color.black));
        backBtn.addActionListener(this);
        this.panel.add(backBtn);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        //This will help you to refresh the Frame Once the changes have been made.
        revalidate();
        repaint();

    }

    private void positionRaceDate(){

        //removing all the previous panels
        for (JPanel panel : jPanelContainer) {
            remove(panel);
        }
        //Clearing the container So it can hold the next values...
        jPanelContainer.clear();

        //creating the heading panel for Race Details.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,55));
        this.panel.setBackground(new Color(0,128,128));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,8));

        //creating the label to hold the heading.
        headingLabel = new JLabel("Race Name & Date Details", SwingConstants.CENTER);
        headingLabel.setPreferredSize(new Dimension(500,30));
        headingLabel.setForeground(Color.white);
        headingLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        //adding headingLabel to the panel.
        this.panel.add(headingLabel);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,250));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,200));

        raceNameLabel = new JLabel("Race Name : ", SwingConstants.CENTER);
        raceNameLabel.setPreferredSize(new Dimension(300,30));
        raceNameLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        raceNameTF = new JTextField(20);
        raceNameTF.setPreferredSize(new Dimension(100,40));
        raceNameTF.setFont(new Font("Tahoma", Font.BOLD,20));
        raceNameTF.setBackground(Color.LIGHT_GRAY);
        raceNameTF.setForeground(new Color(52, 52, 52));
        raceNameTF.setHorizontalAlignment(SwingConstants.CENTER);
        raceNameTF.setBorder(new LineBorder(Color.black));

        this.panel.add(raceNameLabel);
        this.panel.add(raceNameTF);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,100));
        this.panel.setBackground(Color.white);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,8,30));

        yearLabel = new JLabel("Year : ", SwingConstants.CENTER);
        yearLabel.setPreferredSize(new Dimension(130,30));
        yearLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        monthLabel = new JLabel("Month : ", SwingConstants.CENTER);
        monthLabel.setPreferredSize(new Dimension(130,30));
        monthLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        dateLabel = new JLabel("Date : ", SwingConstants.CENTER);
        dateLabel.setPreferredSize(new Dimension(130,30));
        dateLabel.setFont(new Font("Tahoma", Font.BOLD,30));


        yearTF = new JTextField(10);
        yearTF.setPreferredSize(new Dimension(100,40));
        yearTF.setFont(new Font("Tahoma", Font.BOLD,20));
        yearTF.setBackground(Color.LIGHT_GRAY);
        yearTF.setForeground(new Color(52, 52, 52));
        yearTF.setHorizontalAlignment(SwingConstants.CENTER);
        yearTF.setBorder(new LineBorder(Color.black));

        monthTF = new JTextField(10);
        monthTF.setPreferredSize(new Dimension(100,40));
        monthTF.setFont(new Font("Tahoma", Font.BOLD,20));
        monthTF.setBackground(Color.LIGHT_GRAY);
        monthTF.setForeground(new Color(52, 52, 52));
        monthTF.setHorizontalAlignment(SwingConstants.CENTER);
        monthTF.setBorder(new LineBorder(Color.black));

        dateTF = new JTextField(10);
        dateTF.setPreferredSize(new Dimension(100,40));
        dateTF.setFont(new Font("Tahoma", Font.BOLD,20));
        dateTF.setBackground(Color.LIGHT_GRAY);
        dateTF.setForeground(new Color(52, 52, 52));
        dateTF.setHorizontalAlignment(SwingConstants.CENTER);
        dateTF.setBorder(new LineBorder(Color.black));

        this.panel.add(yearLabel);
        this.panel.add(yearTF);

        this.panel.add(monthLabel);
        this.panel.add(monthTF);

        this.panel.add(dateLabel);
        this.panel.add(dateTF);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,60));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,13));

        positionRaceNext = new JButton("NEXT");
        positionRaceNext.setPreferredSize(new Dimension(150,30));
        positionRaceNext.setBackground(new Color(0,128,128));
        positionRaceNext.setForeground(Color.white);
        positionRaceNext.setFocusPainted(false);
        positionRaceNext.setFont(new Font("Tahoma", Font.BOLD, 15));
        positionRaceNext.setBorder(new LineBorder(Color.black));
        positionRaceNext.addActionListener(this);
        this.panel.add(positionRaceNext);


        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        //This will help you to refresh the Frame Once the changes have been made.
        revalidate();
        repaint();
    }

    private void positionRaceDateValidate(){

        int yearDuplicate = Integer.parseInt(this.yearTF.getText());
        int monthDuplicate = Integer.parseInt(this.monthTF.getText());
        int dateDuplicate = Integer.parseInt(this.dateTF.getText());

        try {
            //Here setting the race date.
            raceDate = LocalDate.of(yearDuplicate, monthDuplicate, dateDuplicate);
            displayPositionRaceDetail();

            //If the date is not valid it will show the error message.
        } catch (Exception e) {

            //removing all the previous panels
            for (JPanel panel : jPanelContainer) {
                remove(panel);
            }
            //Clearing the container So it can hold the next values...
            jPanelContainer.clear();

            //creating the heading panel for Race Details.
            this.panel = new JPanel();
            this.panel.setPreferredSize(new Dimension(1150,400));
            this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,350));
            //panel1.setBorder(new LineBorder(Color.black));

            //creating the label to hold the heading.
            headingLabel = new JLabel("!! InCorrect Value For Date !!", SwingConstants.CENTER);
            headingLabel.setPreferredSize(new Dimension(500,30));
            headingLabel.setForeground(Color.red);
            headingLabel.setFont(new Font("Tahoma", Font.BOLD,30));

            //adding headingLabel to the panel.
            this.panel.add(headingLabel);

            //adding panel to the frame.
            add(this.panel);
            //To store the panels in the container so can remove when necessary.
            jPanelContainer.add(this.panel);

            this.panel = new JPanel();
            this.panel.setPreferredSize(new Dimension(1150,40));
            this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,4));

            positionRetryBtn = new JButton("Retry");
            positionRetryBtn.setPreferredSize(new Dimension(150,30));
            positionRetryBtn.setBackground(Color.red);
            positionRetryBtn.setForeground(Color.WHITE);
            positionRetryBtn.setFocusPainted(false);
            positionRetryBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
            positionRetryBtn.setBorder(new LineBorder(Color.black));
            positionRetryBtn.addActionListener(this);
            this.panel.add(positionRetryBtn);

            //adding panel to the Frame.
            add(this.panel);
            //To store the panels in the container so can remove when necessary.
            jPanelContainer.add(this.panel);

            //This will help you to refresh the Frame Once the changes have been made.
            revalidate();
            repaint();

        }

    }


    private void displayPositionRaceDetail(){

        //removing all the previous panels
        for (JPanel panel : jPanelContainer) {
            remove(panel);
        }
        //Clearing the container So it can hold the next values...
        jPanelContainer.clear();

        //getting the raceName
        String raceNameDuplicate = this.raceNameTF.getText();

        //creating the heading panel for Race Details.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,55));
        this.panel.setBackground(Color.ORANGE);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,8));
        //panel1.setBorder(new LineBorder(Color.black));

        //creating the label to hold the heading.
        headingLabel = new JLabel("Position Race " + "\"" + raceNameDuplicate + "\"" + " Details", SwingConstants.CENTER);
        headingLabel.setPreferredSize(new Dimension(1150,30));
        headingLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        //adding headingLabel to the panel.
        this.panel.add(headingLabel);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        //Creating the panel to hold the Date of the race.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,40));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));

        raceDateLabel = new JLabel("Race Date  : ", SwingConstants.RIGHT);
        raceDateLabel.setPreferredSize(new Dimension(200,25));
        raceDateLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        raceDateLabel.setForeground(Color.red);

        dateLabel = new JLabel(raceDate + "", SwingConstants.LEFT);
        dateLabel.setPreferredSize(new Dimension(200,25));
        dateLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        dateLabel.setForeground(Color.red);

        this.panel.add(raceDateLabel);
        this.panel.add(dateLabel);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        //Creating the panel to hold the subheadings.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,40));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,10));

        driverNameLabel = new JLabel("Driver Name", SwingConstants.CENTER);
        driverNameLabel.setPreferredSize(new Dimension(200,25));
        driverNameLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        driverNameLabel.setForeground(new Color(47,79,79));
        driverNameLabel.setBorder(new LineBorder(new Color(47,79,79)));

        startingPositionLabel = new JLabel("Starting Position", SwingConstants.CENTER);
        startingPositionLabel.setPreferredSize(new Dimension(300,25));
        startingPositionLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        startingPositionLabel.setForeground(new Color(47,79,79));
        startingPositionLabel.setBorder(new LineBorder(new Color(47,79,79)));

        placeLabel = new JLabel("Place", SwingConstants.CENTER);
        placeLabel.setPreferredSize(new Dimension(200,25));
        placeLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        placeLabel.setForeground(new Color(47,79,79));
        placeLabel.setBorder(new LineBorder(new Color(47,79,79)));

        this.panel.add(driverNameLabel);
        this.panel.add(startingPositionLabel);
        this.panel.add(placeLabel);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        //............................................ALGORITHM...............................................

        //Drivers those who have a Constructor Team are eligible.
        ArrayList<Formula1Driver> eligibleDriverList = new ArrayList<>();

        for(Formula1Driver driver : formula1DriverList){
            if (driver.getTeam() != null) {
                eligibleDriverList.add(driver);
            }
        }

        //Counting how many drivers participating in the race...
        int eligibleCount = eligibleDriverList.size();

        //To stop that starting position to be overridden.
        ArrayList<Integer> startingPositionList = new ArrayList<>();

        //To hold the Places to identify that each places is unique.
        ArrayList<Integer> placeList = new ArrayList<>();

        for(int i = 0; i < eligibleCount; i++){
            placeList.add(i,0);
        }

        //To create Random values/positions for the driver.
        Random random = new Random();


        //To get the unique random Starting Position for all the eligibleDrivers.
        for(int i = 0; i < eligibleCount; i++){

            while(true){

                int startingPosition = 1 + random.nextInt(eligibleCount);

                int index = startingPositionList.indexOf(startingPosition);

                if (index == -1) {
                    startingPositionList.add(startingPosition);
                    break;
                }
            }
        }


        //To reference the driver who got place 1 in the race.
        int refNoPos1;

        while(true) {

            //to Define the Probability thing I am getting one random number out of 100.
            int randomNumber = 1 + random.nextInt(100);

            if (randomNumber <= 40) {

                if (startingPositionList.contains(1)) {

                    //getting the index of the driver who starts the race with starting position 1.
                    refNoPos1 = startingPositionList.indexOf(1);
                    break;
                }

            } else if (randomNumber <= 70) {

                if (startingPositionList.contains(2)) {

                    //getting the index of the driver who starts the race with starting position 2.
                    refNoPos1 = startingPositionList.indexOf(2);
                    break;

                }

            } else if (randomNumber <= 80) {

                if (startingPositionList.contains(3)) {

                    //getting the index of the driver who starts the race with starting position 3.
                    refNoPos1 = startingPositionList.indexOf(3);
                    break;

                }

            } else if (randomNumber <= 90) {

                if (startingPositionList.contains(4)) {

                    //getting the index of the driver who starts the race with starting position 4.
                    refNoPos1 = startingPositionList.indexOf(4);
                    break;

                }

            } else if (randomNumber <= 92) {

                if (startingPositionList.contains(5)) {

                    //getting the index of the driver who starts the race with starting position 5.
                    refNoPos1 = startingPositionList.indexOf(5);
                    break;

                }

            } else if (randomNumber <= 94) {

                if (startingPositionList.contains(6)) {

                    //getting the index of the driver who starts the race with starting position 6.
                    refNoPos1 = startingPositionList.indexOf(6);
                    break;

                }

            } else if (randomNumber <= 96) {

                if (startingPositionList.contains(7)) {

                    //getting the index of the driver who starts the race with starting position 7.
                    refNoPos1 = startingPositionList.indexOf(7);
                    break;

                }

            } else if (randomNumber <= 98) {

                if (startingPositionList.contains(8)) {

                    //getting the index of the driver who starts the race with starting position 8.
                    refNoPos1 = startingPositionList.indexOf(8);
                    break;

                }

            } else {

                if (startingPositionList.contains(9)) {

                    //getting the index of the driver who starts the race with starting position 9.
                    refNoPos1 = startingPositionList.indexOf(9);
                    break;
                }
            }

        }

        //here setting the place for the driver who got the 1st place in the race.
        placeList.set(refNoPos1, 1);

        //To store the raceDetails like Position and the Driver who got that Position.
        HashMap<Integer, String> raceDetails = new HashMap<>();

        //giving random places for other drivers.
        int place;
        //for(Formula1Driver driver : eligibleDriverList){
        for(int i = 0; i < eligibleDriverList.size(); i++){

            //confirming the place for the driver who got the 1st place earlier is not changing.
            if(i != refNoPos1){

                //Confirming that all the other drivers except the one who got 1st place are getting a unique places.
                while(true){

                    place = 2 + random.nextInt(eligibleCount - 1);

                    int index = placeList.indexOf(place);

                    //checking that the place is not being overridden. getting every time a different place.
                    if (index == -1) {

                        placeList.set(i, place);


                        //changing the statistics of the other drivers who didn't get the 1st place.
                        int value;
                        if (eligibleDriverList.get(i).getStatistics().get(place) != null) {
                            value = eligibleDriverList.get(i).getStatistics().get(place);
                            value = value + 1;
                        } else {
                            value = 1;
                        }
                        eligibleDriverList.get(i).updateStatistics(place, value);
                        eligibleDriverList.get(i).calculatePointsAndNoOfRaces();


                        break;

                    }

                }

                //save all the driver details in the hashmap position and their names.
                raceDetails.put(place, eligibleDriverList.get(i).getDriverName());



            }else {

                //changing the statistics for the driver who got the 1st place.
                int value;
                if (eligibleDriverList.get(i).getStatistics().get(1) != null) {
                    value = eligibleDriverList.get(i).getStatistics().get(1);
                    value = value + 1;
                } else {
                    value = 1;
                }
                eligibleDriverList.get(i).updateStatistics(1, value);
                eligibleDriverList.get(i).calculatePointsAndNoOfRaces();

                //for the driver who comes 1st in the race.
                raceDetails.put(1, eligibleDriverList.get(i).getDriverName());

            }


            //GUI stuffs comes here.

            //JPanel responsible to add the driver Race Details.
            this.panel = new JPanel();
            this.panel.setPreferredSize(new Dimension(1150,27));
            this.panel.setBackground(Color.white);
            this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,3));

            //label to store the driverName.
            driverNameLabel = new JLabel(eligibleDriverList.get(i).getDriverName(), SwingConstants.CENTER);
            driverNameLabel.setPreferredSize(new Dimension(200,20));
            driverNameLabel.setFont(new Font("Tahoma", Font.BOLD,20));
            driverNameLabel.setBorder(new LineBorder(Color.black));

            //label to hold the random Starting Position of all the drivers.
            startingPositionLabel = new JLabel(startingPositionList.get(i) + "", SwingConstants.CENTER);
            startingPositionLabel.setPreferredSize(new Dimension(300,20));
            startingPositionLabel.setForeground(Color.red);
            startingPositionLabel.setFont(new Font("Tahoma", Font.BOLD,20));
            startingPositionLabel.setBorder(new LineBorder(Color.black));

            //label to hold the random place achieve by the drivers.
            placeLabel = new JLabel(placeList.get(i) + "", SwingConstants.CENTER);
            placeLabel.setPreferredSize(new Dimension(200,20));
            placeLabel.setFont(new Font("Tahoma", Font.BOLD,20));
            placeLabel.setBorder(new LineBorder(Color.black));

            //adding labels to the panel.
            this.panel.add(driverNameLabel);
            this.panel.add(startingPositionLabel);
            this.panel.add(placeLabel);

            //adding panel to the Frame.
            add(this.panel);
            //To store the panels in the container so can remove when necessary.
            jPanelContainer.add(this.panel);

        }


        //adding the race to the raceList in order maintain all the details of a race.
        raceList.add(new Race(raceNameDuplicate, raceDate, raceDetails));


        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,40));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,4));

        backBtn = new JButton("BACK");
        backBtn.setPreferredSize(new Dimension(150,30));
        backBtn.setBackground(new Color(100, 150, 10));
        backBtn.setForeground(Color.white);
        backBtn.setFocusPainted(false);
        backBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        backBtn.setBorder(new LineBorder(Color.black));
        backBtn.addActionListener(this);
        this.panel.add(backBtn);


        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        //This will help you to refresh the Frame Once the changes have been made.
        revalidate();
        repaint();


    }

    private void displayAsceDateRace(){

        //removing all the previous panels
        for (JPanel panel : jPanelContainer) {
            remove(panel);
        }
        //Clearing the container So it can hold the next values...
        jPanelContainer.clear();


        //creating the heading panel for Race Details.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,55));
        this.panel.setBackground(Color.ORANGE);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,8));
        //panel1.setBorder(new LineBorder(Color.black));

        //creating the label to hold the heading.
        headingLabel = new JLabel("Race Details", SwingConstants.CENTER);
        headingLabel.setPreferredSize(new Dimension(1150,30));
        headingLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        //adding headingLabel to the panel.
        this.panel.add(headingLabel);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        //Creating the panel5 to hold the Date of the race.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,40));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,10));

        headingLabel = new JLabel("Date In Ascending Order", SwingConstants.CENTER);
        headingLabel.setPreferredSize(new Dimension(600,25));
        headingLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        headingLabel.setForeground(Color.red);

        this.panel.add(headingLabel);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        //Creating the panel5 to hold the subheadings.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,40));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,10));

        raceNameLabel = new JLabel("Race Name", SwingConstants.CENTER);
        raceNameLabel.setPreferredSize(new Dimension(200,25));
        raceNameLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        raceNameLabel.setForeground(new Color(47,79,79));
        raceNameLabel.setBorder(new LineBorder(new Color(47,79,79)));

        dateLabel = new JLabel("Date", SwingConstants.CENTER);
        dateLabel.setPreferredSize(new Dimension(200,25));
        dateLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        dateLabel.setForeground(new Color(47,79,79));
        dateLabel.setBorder(new LineBorder(new Color(47,79,79)));

        this.panel.add(raceNameLabel);
        this.panel.add(dateLabel);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);



        int sizeRaceList = raceList.size();

        //copying and storing it in the arrays to make the execution even faster.
        Race[] sortedRaceList = new Race[sizeRaceList];

        for (int i = 0; i < sortedRaceList.length; i++) {
            sortedRaceList[i] = raceList.get(i);
        }


        //To hold Temporary Race.
        Race temporaryRace;

        for (int i = 0; i < sortedRaceList.length; i++) {
            for (int j = i + 1; j < sortedRaceList.length; j++) {
                if (sortedRaceList[i].getRaceDate().compareTo(sortedRaceList[j].getRaceDate()) > 0) {
                    temporaryRace = sortedRaceList[i];
                    sortedRaceList[i] = sortedRaceList[j];
                    sortedRaceList[j] = temporaryRace;

                }
            }
        }


        //Going through every driver and getting the details to be print.
        for(int i = 0; i < sortedRaceList.length; i++){

            //GUI stuffs comes here.

            //JPanel responsible to add the driver race details.
            this.panel = new JPanel();
            this.panel.setPreferredSize(new Dimension(1150,27));
            this.panel.setBackground(Color.white);
            this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,3));

            //label to store the RaceName.
            raceNameLabel = new JLabel(sortedRaceList[i].getRaceName(), SwingConstants.CENTER);
            raceNameLabel.setPreferredSize(new Dimension(200,20));
            raceNameLabel.setFont(new Font("Tahoma", Font.BOLD,20));
            raceNameLabel.setBorder(new LineBorder(Color.black));

            //label to hold the date.
            dateLabel = new JLabel(sortedRaceList[i].getRaceDate() + "", SwingConstants.CENTER);
            dateLabel.setPreferredSize(new Dimension(200,20));
            dateLabel.setFont(new Font("Tahoma", Font.BOLD,20));
            dateLabel.setBorder(new LineBorder(Color.black));

            //adding labels to the panel.
            this.panel.add(raceNameLabel);
            this.panel.add(dateLabel);

            //adding panel to the Frame.
            add(this.panel);

            //To store the panels in the container so can remove when necessary.
            jPanelContainer.add(this.panel);


        }


        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,40));
        //panel3Button.setBackground(Color.white);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,4));

        backBtn = new JButton("BACK");
        backBtn.setPreferredSize(new Dimension(150,30));
        backBtn.setBackground(new Color(100, 150, 10));
        backBtn.setForeground(Color.white);
        backBtn.setFocusPainted(false);
        backBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        backBtn.setBorder(new LineBorder(Color.black));
        backBtn.addActionListener(this);
        this.panel.add(backBtn);


        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        //This will help you to refresh the Frame Once the changes have been made.
        revalidate();
        repaint();

    }


    private void searchDriverMenu(){

        //removing all the previous panels
        for (JPanel panel : jPanelContainer) {
            remove(panel);
        }
        //Clearing the container So it can hold the next values...
        jPanelContainer.clear();


        //creating the heading panel for Race Details.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,55));
        this.panel.setBackground(new Color(0,128,128));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,8));
        //panel1.setBorder(new LineBorder(Color.black));

        //creating the label to hold the heading.
        headingLabel = new JLabel("Search The Driver", SwingConstants.CENTER);
        headingLabel.setPreferredSize(new Dimension(500,30));
        headingLabel.setForeground(Color.white);
        headingLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        //adding headingLabel to the panel.
        this.panel.add(headingLabel);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,250));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,200));

        driverNameLabel = new JLabel("Driver Name : ", SwingConstants.CENTER);
        driverNameLabel.setPreferredSize(new Dimension(300,30));
        driverNameLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        driverSearchNameTF = new JTextField(20);
        driverSearchNameTF.setPreferredSize(new Dimension(100,40));
        driverSearchNameTF.setFont(new Font("Tahoma", Font.BOLD,20));
        driverSearchNameTF.setBackground(Color.LIGHT_GRAY);
        driverSearchNameTF.setForeground(new Color(139,0,0));
        driverSearchNameTF.setHorizontalAlignment(SwingConstants.CENTER);
        driverSearchNameTF.setBorder(new LineBorder(Color.black));

        this.panel.add(driverNameLabel);
        this.panel.add(driverSearchNameTF);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,100));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,30));
        //this.panel.setBorder(new LineBorder(Color.black));

        driverSearchNext = new JButton("SEARCH");
        driverSearchNext.setPreferredSize(new Dimension(200,40));
        driverSearchNext.setBackground(new Color(0,128,128));
        driverSearchNext.setForeground(Color.white);
        driverSearchNext.setFocusPainted(false);
        driverSearchNext.setFont(new Font("Tahoma", Font.BOLD, 20));
        driverSearchNext.setBorder(new LineBorder(Color.black));
        driverSearchNext.addActionListener(this);
        this.panel.add(driverSearchNext);


        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        //This will help you to refresh the Frame Once the changes have been made.
        revalidate();
        repaint();


    }

    private void displayDriverDetails(){

        //removing all the previous panels
        for (JPanel panel : jPanelContainer) {
            remove(panel);
        }
        //Clearing the container So it can hold the next values...
        jPanelContainer.clear();


        //getting the DriverName entered in textField.
        String driverNameDuplicate = this.driverSearchNameTF.getText();


        //creating the heading panel for Race Details.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,55));
        this.panel.setBackground(Color.ORANGE);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,8));
        //panel1.setBorder(new LineBorder(Color.black));

        //creating the label to hold the heading.
        headingLabel = new JLabel("Search Details", SwingConstants.CENTER);
        headingLabel.setPreferredSize(new Dimension(1150,30));
        headingLabel.setFont(new Font("Tahoma", Font.BOLD,30));

        //adding headingLabel to the panel.
        this.panel.add(headingLabel);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);



        //Creating the panel to hold the Date of the race.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,40));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));

        driverNameLabel = new JLabel("Driver Name : ", SwingConstants.RIGHT);
        driverNameLabel.setPreferredSize(new Dimension(300,25));
        driverNameLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        driverNameLabel.setForeground(Color.red);
        //driverNameLabel.setBorder(new LineBorder(new Color(47,79,79)));

        placeLabel = new JLabel(driverNameDuplicate.toUpperCase(Locale.ROOT), SwingConstants.LEFT);
        placeLabel.setPreferredSize(new Dimension(300,25));
        placeLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        placeLabel.setForeground(Color.red);
        //placeLabel.setBorder(new LineBorder(new Color(47,79,79)));

        this.panel.add(driverNameLabel);
        this.panel.add(placeLabel);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);


        //Creating the panel to hold the subheadings.
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,40));
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,10));

        raceDateLabel = new JLabel("Race Date", SwingConstants.CENTER);
        raceDateLabel.setPreferredSize(new Dimension(200,25));
        raceDateLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        raceDateLabel.setForeground(new Color(47,79,79));
        raceDateLabel.setBorder(new LineBorder(new Color(47,79,79)));

        raceNameLabel = new JLabel("Race Name", SwingConstants.CENTER);
        raceNameLabel.setPreferredSize(new Dimension(200,25));
        raceNameLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        raceNameLabel.setForeground(new Color(47,79,79));
        raceNameLabel.setBorder(new LineBorder(new Color(47,79,79)));

        placeLabel = new JLabel("Place", SwingConstants.CENTER);
        placeLabel.setPreferredSize(new Dimension(200,25));
        placeLabel.setFont(new Font("Tahoma", Font.BOLD,25));
        placeLabel.setForeground(new Color(47,79,79));
        placeLabel.setBorder(new LineBorder(new Color(47,79,79)));

        this.panel.add(raceDateLabel);
        this.panel.add(raceNameLabel);
        this.panel.add(placeLabel);

        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);



        //...........................Algorithm..............................

        //Flag to check whether the driver entered has been participated at least in a Race.
        boolean flag = true;

        //going through all the races that took place.
        for(Race race : raceList){

            for(int keys : race.getRaceDetails().keySet()){

                //checking whether the driver name matches in any positions
                if(race.getRaceDetails().get(keys).equalsIgnoreCase(driverNameDuplicate)){

                    flag = false;

                    //JPanel responsible to add the driver race details.
                    this.panel = new JPanel();
                    this.panel.setPreferredSize(new Dimension(1150,27));
                    this.panel.setBackground(Color.white);
                    this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,3));

                    raceDateLabel = new JLabel(race.getRaceDate() + "", SwingConstants.CENTER);
                    raceDateLabel.setPreferredSize(new Dimension(200,20));
                    raceDateLabel.setFont(new Font("Tahoma", Font.BOLD,20));
                    raceDateLabel.setBorder(new LineBorder(Color.black));

                    raceNameLabel = new JLabel(race.getRaceName(), SwingConstants.CENTER);
                    raceNameLabel.setPreferredSize(new Dimension(200,20));
                    raceNameLabel.setFont(new Font("Tahoma", Font.BOLD,20));
                    raceNameLabel.setBorder(new LineBorder(Color.black));

                    placeLabel = new JLabel(keys + "", SwingConstants.CENTER);
                    placeLabel.setPreferredSize(new Dimension(200,20));
                    placeLabel.setForeground(Color.red);
                    placeLabel.setFont(new Font("Tahoma", Font.BOLD,20));
                    placeLabel.setBorder(new LineBorder(Color.black));

                    //adding labels to the panel.
                    this.panel.add(raceDateLabel);
                    this.panel.add(raceNameLabel);
                    this.panel.add(placeLabel);

                    //adding panel to the Frame.
                    add(this.panel);
                    //To store the panels in the container so can remove when necessary.
                    jPanelContainer.add(this.panel);

                }

            }

        }

        //To show that the driver didn't participate in any Race.
        if (flag){

            remove(this.panel);

            //Creating the panel to show that the driver didn't participate in any Race.
            this.panel = new JPanel();
            this.panel.setPreferredSize(new Dimension(1150,320));
            this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,35,250));
            //this.panel.setBorder(new LineBorder(new Color(47,79,79)));

            headingLabel = new JLabel("!! This Driver didn't participate in any of the Races !!", SwingConstants.CENTER);
            headingLabel.setPreferredSize(new Dimension(1150,40));
            headingLabel.setFont(new Font("Tahoma", Font.BOLD,40));
            headingLabel.setForeground(new Color(47,79,79));

            //adding labels to the panel.
            this.panel.add(headingLabel);

            //adding panel to the Frame.
            add(this.panel);
            //To store the panels in the container so can remove when necessary.
            jPanelContainer.add(this.panel);


        }


        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(1150,40));
        //panel3Button.setBackground(Color.white);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,4));

        backBtn = new JButton("BACK");
        backBtn.setPreferredSize(new Dimension(150,30));
        backBtn.setBackground(new Color(100, 150, 10));
        backBtn.setForeground(Color.white);
        backBtn.setFocusPainted(false);
        backBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        backBtn.setBorder(new LineBorder(Color.black));
        backBtn.addActionListener(this);
        this.panel.add(backBtn);


        //adding panel to the Frame.
        add(this.panel);
        //To store the panels in the container so can remove when necessary.
        jPanelContainer.add(this.panel);

        //This will help you to refresh the Frame Once the changes have been made.
        revalidate();
        repaint();
    }

}
