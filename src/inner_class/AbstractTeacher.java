package inner_class;

// внутренний класс, объявленный внутри метода
public abstract class AbstractTeacher {
    private int id;

    // Создаем конструктор класса AbstractTeacher
    public AbstractTeacher(int id) {
        this.id = id;
    }

    // создаем abstract метод
    public abstract boolean excludeStudent(String name);
}

// Создаем класс Teacher и наследуем AbstractTeacher
class Teacher extends AbstractTeacher {

    // Переопределяем методы
    public Teacher(int id) {
        super(id);
    }

    @Override
    public boolean excludeStudent(String name) {
        return false;
    }
}

// Создаем класс TeacherCreator
class TeacherCreator {

    // объявляем класс внутри метода
    public static AbstractTeacher createTeacher(int id) {

        class Rector extends AbstractTeacher {

            // переопределяем методы
            public Rector(int id) {
                super(id);
            }

            @Override
            public boolean excludeStudent(String name) {
                if (name != null) {                                // изменение статуса студента в базе данных
                    return true;
                } else {
                    return false;
                }
            }
        }                                                          // конец внутреннего класса

        if (isRectorId(id)) {
            return new Rector(id);
        } else {
            return new Teacher(id);
        }
    }

    // проверка id
    private static boolean isRectorId(int id) {
        return id == 6;
    }
}

class TeacherLogic {
    public void excludeProcess(int rectorId, String nameStudent) {
        AbstractTeacher teacher = TeacherCreator.createTeacher(rectorId);

        System.out.println("Студент: " + nameStudent +
                " отчислен:" + teacher.excludeStudent(nameStudent));
    }
}

class Runner {
    public static void main(String[] args) {
        TeacherLogic tl = new TeacherLogic();
        tl.excludeProcess(777, "Олейников");
        tl.excludeProcess(6, "Олейников");
    }

}
