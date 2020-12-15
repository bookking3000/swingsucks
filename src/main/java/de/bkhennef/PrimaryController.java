package de.bkhennef;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.ResultSet;

public class PrimaryController {

    private ObservableList<ObservableList> data;
    @FXML
    private TableView tableview;

    @FXML
    public void loadData(){
        tableview.setItems(null);
        tableview.getColumns().removeAll();

        Connection connection ;
        data = FXCollections.observableArrayList();
        try{
            connection = DBConn.getConnection();
            String SQL = "SELECT * from SampleEntity";
            ResultSet rs = connection.createStatement().executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                tableview.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }
            tableview.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error loading Data");
        }
    }
}