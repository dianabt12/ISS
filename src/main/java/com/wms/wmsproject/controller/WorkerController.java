package com.wms.wmsproject.controller;

import com.wms.wmsproject.model.Worker;
import com.wms.wmsproject.model.dtos.TaskDto;
import com.wms.wmsproject.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class WorkerController implements Controller {
    ObservableList<TaskDto> tasks = FXCollections.observableArrayList();



    private Worker loggedWorker;
    private Service service;

    @Override
    public void update() {
//        populateTasksTable();
    }

    public void setService(Service service) {
        this.service = service;
        service.addObserver(this);
        initializeTasksTable();
    }

//    private void populateTasksTable() {
//        tasks.clear();
//        tasks.setAll(service.getTasksForWorker(loggedWorker.getId())
//                .stream()
//                .map(TaskDto::new)
//                .toList());
//    }

    private void initializeTasksTable() {

    }

    public void setLoggedWorker(Worker loggedWorker) {
        this.loggedWorker = loggedWorker;
//        populateTasksTable();
    }

    public void logoutClicked() {
        service.removeObserver(this);
        service.stopWorking(loggedWorker.getId());
    }
}
