package Interfaces;

import Serializebles.Student;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IStudentService extends Remote {
    void addStudent(Student student) throws RemoteException;
    void deleteStudent(String name) throws RemoteException;
    List<Student> listStudents() throws RemoteException;
}