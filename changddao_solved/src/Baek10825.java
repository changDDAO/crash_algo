public class Baek10825 {
    public static void main(String[] args) {

    }
    static class Student implements Comparable<Student>{
        private String stdName;
        private int kor;
        private int eng;
        private int math;

        public Student(String stdName, int kor, int eng, int math) {
            this.stdName = stdName;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.kor == o.kor) {
                if(this.eng==o.eng){
                    if (this.math == o.math) {

                    }
                    return o.math-this.math;
                }
                return this.eng-o.eng;
            }
            return o.kor-this.kor;
        }
    }
}
