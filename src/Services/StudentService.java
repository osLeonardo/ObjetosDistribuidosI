package Services;

import Interfaces.IStudentService;
import Serializebles.Student;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private final List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) throws RemoteException {
        students.add(student);
    }

    @Override
    public void deleteStudent(String name) throws RemoteException {
        students.removeIf(student -> student.getName().equals(name));
    }

    @Override
    public List<Student> listStudents() throws RemoteException {
        return new ArrayList<>(students);
    }
}