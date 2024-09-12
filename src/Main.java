import java.util.*;

//Задача 1
class Person {
    String Name;
    int Age;
    char Gender;

    public Person(String name, int age, char gender) {
        this.Name = name;
        this.Age = age;
        this.Gender = gender;
    }

    public void PersonInfo() {
        System.out.println("Имя: "+ this.Name + "\nВозраст: "+this.Age+"\nПол: "+this.Gender);
    }

    public void IncreaseAge(int age) { this.Age = age; }

    public void ChangeName(String name) { this.Name = name; }
}
//Задача 2
class Worker extends Person {
    int Salary;
    public Worker(String name, int age, char gender, int salary) {
        super(name, age, gender);
        this.Salary = salary;
    }
}

class Manager extends Worker {
    Worker[] Slaves;
    public Manager(String name, int age, char gender, int salary, Worker[] workers) {
        super(name, age, gender, salary);
        this.Slaves = workers;
    }
}

//Задача 3
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Гав-гав!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Мяу-мяу!");
    }
}

class Cow implements Animal {
    public void makeSound() {
        System.out.println("Мууууу!");
    }
}

//Задача 4
abstract class Transport {
    abstract void move();
}

class Car extends Transport {
    void move() {
        System.out.println("Едет автомобиль");
    }
}
class Bike extends Transport {
    void move() {
        System.out.println("Едет мотоцикл");
    }
}

//Задача 5
//Создайте класс Book с полями title, author, и year. Создайте класс Library, который содержит
// коллекцию книг и методы для добавления книг, поиска по автору и году публикации.
class Book {
    String title;
    String author;
    int year;
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

class Library {
    List<Book> books;
    public void AddBook(Book book) {
        books.add(book);
    }
    public Book SearchByTitle(int year) throws Exception {
        for (Book book: books) {
            if (book.year == year) return book;
        }
        throw new Exception("Книга не найдена");
    }
    public Book SearchByAuthor(String author) throws Exception {
        for (Book book: books) {
            if (book.author.equals(author)) return book;
        }
        throw new Exception("Книга не найдена");
    }
}
//Задача 6
class BankAccount {
    private int accountNumber;
    private int balance;
    public BankAccount(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void GetMoney(int money) { balance -= money; }
    public void PutMoney(int money) { balance += money; }
}
//Задача 7
class Counter {
    static int count;
    public Counter() {
        addObject();
    }
    static void addObject() {
        count += 1;
    }
}
//Задача 8
//Создайте абстрактный класс Shape с абстрактным методом getArea(). Реализуйте классы
// Circle и Rectangle, которые наследуют от Shape и вычисляют площадь круга и
// прямоугольника соответственно.
abstract class Shape {
    abstract double getArea();
}
class Circle extends Shape{
    int radius;
    public Circle(int rad) {
        radius = rad;
    }
    double getArea() {
        return radius*radius*Math.PI;
    }
}
class Rectangle extends Shape{
    int a;
    int b;
    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public double getArea() {
        return a*b;
    }
}
//Задача 9
//Создайте класс Animal с методом move(). Реализуйте классы Fish, Bird и Dog, которые
// наследуют Animal и переопределяют метод move() (рыба плавает, птица летает, собака бегает).
class Animal1 {
    void move() {
        System.out.println("Я иду");
    }
}
class Fish extends Animal1 {
    void move() {
        System.out.println("Рыба плавает");
    }
}
class Bird extends Animal1 {
    void move() {
        System.out.println("Птица летает");
    }
}
class Dog1 extends Animal1 {
    void move() {
        System.out.println("Собака бегает");
    }
}
//Задание 10
class Student{
    String name;
    int group;
    double grade;
    public Student(String name, int group, double grade) {
        this.name = name;
        this.group = group;
        this.grade = grade;
    }
}
class University{

    public ArrayList<Student> students;
    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> NameSort() {
        ArrayList<Student> sortedList = new ArrayList<>(students);
        // Сортируем студентов по имени
        Collections.sort(sortedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        });
        return sortedList;
    }
    public ArrayList<Student> Filter(double minmark, double maxmark) {
        ArrayList<Student> filteredList = new ArrayList<>();
        for (Student student : students) {
            if (student.grade >= minmark && student.grade <= maxmark) {
                filteredList.add(student);
            }
        }
        return filteredList;
    }
}
//Задача 11
class Product {
    String name;
    private int price;
    private int quantity;
    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
class Store {
    private ArrayList<Product> products;
    public void addProduct(Product prod) {
        products.add(prod);
    }
    public void delProduct(String name) {
        products.removeIf(prod -> Objects.equals(prod.name, name));
    }
    public Product NameSearch(String name) {
        for (Product prod: products) {
            if (prod.name.equals(name)) return prod;
        }
        return null;
    }
}
//Задача 12
//Создайте интерфейс PaymentSystem с методами pay() и refund(). Реализуйте классы
// CreditCard и PayPal, которые реализуют этот интерфейс.
interface PaymentSystem {
    void pay();
    void refund();
}
class CreditCard {
    void pay() {
        System.out.println("Плачу кредитной картой");
    }
    void refund() {
        System.out.println("Возврат средств на кредитку");
    }
}
class PayPal {
    void pay() {
        System.out.println("Оплата PayPal");
    }
    void refund() {
        System.out.println("Возврат средств на счёт PayPal");
    }
}
//Задача 13
//Создайте класс UniqueID, который генерирует уникальные идентификаторы для объектов
// каждого созданного класса. Реализуйте этот функционал через статическое поле и метод.
class UniqueID {
    static Random rand = new Random();
    int ID;
    static void generateID(UniqueID obj) {
        obj.ID = rand.nextInt(10000);
    }
}
//Задача 14
class Point {
    int X;
    int Y;
    public Point(int x, int y) {
        X = x;
        Y = y;
    }
}
class Rectangle1 {
    Point UpperLeft;
    Point LowerRight;
    public double getArea() {
        double d = Math.pow(UpperLeft.X- LowerRight.X, 2) + Math.pow(UpperLeft.Y - LowerRight.Y, 2);
        double a = UpperLeft.Y - LowerRight.Y;
        return a * Math.pow(d - a*a, 0.5);
    }
}
//Задача 15
class ComplexNumber {
    double real;
    double imaginary;
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    ComplexNumber Sum(ComplexNumber number) {
        return new ComplexNumber(this.real + number.real, this.imaginary + number.imaginary);
    }
    ComplexNumber Subtract(ComplexNumber number) {
        return new ComplexNumber(this.real - number.real, this.imaginary - number.imaginary);
    }
    ComplexNumber Multiply(ComplexNumber number) {
        return new ComplexNumber(this.real * this.imaginary - number.real * number.imaginary, this.real * number.imaginary + number.real * this.imaginary);
    }
    ComplexNumber Divide(ComplexNumber number) {
        ComplexNumber complexNumber = null;
        complexNumber.real = (this.real*this.imaginary + number.real * number.imaginary)/(Math.pow(this.imaginary, 2) + Math.pow(number.imaginary, 2));
        complexNumber.imaginary = (this.imaginary * number.real - this.real * number.imaginary)/(Math.pow(this.imaginary, 2) + Math.pow(number.imaginary, 2));
        return complexNumber;
    }
}
//Задача 16
//Создайте класс Matrix, представляющий двумерную матрицу. Реализуйте методы для сложения
// и умножения матриц. Продемонстрируйте перегрузку методов.
class Matrix {
    int rows;
    int columns;
    int[][] data;
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        data = new int[rows][columns];
    }
    public Matrix(int[][] arr) {
        rows = arr.length;
        columns = arr[0].length;
        data = arr;
    }
    public Matrix Sum(Matrix matrix) {
        Matrix newMatrix = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; i < this.columns; i++) {
                newMatrix.data[i][j] = this.data[i][j] + matrix.data[i][j];
            }
        }
        return newMatrix;
    }
    public Matrix Subtract(Matrix matrix) {
        Matrix newMatrix = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; i < this.columns; i++) {
                newMatrix.data[i][j] = this.data[i][j] - matrix.data[i][j];
            }
        }
        return newMatrix;
    }
}
//Задача 17
class Character {
    String name;
    protected int health;
    Weapon weapon;
    public void Damage(int num) {
        this.health -= num;
    }
}
class Player extends Character{
    public void Attack(Enemy enemy) {
        System.out.println("Игрок " + this.name + "атакует врага " + enemy.name + ": урон " + this.weapon.damage);
        enemy.Damage(this.weapon.damage);
    }
}
class Enemy extends Character{
    public void Attack(Player player) {
        System.out.println("Враг " + this.name + "атакует игрока " + player.name + ": урон " + this.weapon.damage);
        player.Damage(this.weapon.damage);
    }
}
class Weapon {
    String name;
    int damage;
}
//Задача 18
class Order {
    int ID;
    int TotalSum;
    ArrayList<Product1> products;
    void addProduct(Product1 product) {
        TotalSum += product.cost;
        products.add(product);
    }
}
class Customer {
    int ID;
    ArrayList<Order> orders;
    void addOrder(Order order) {
        orders.add(order);
    }
    void ShowOrders() {
        System.out.println("Номер заказа Общая стоимость");
        for (Order order: orders) {
            System.out.printf("{1} {2}", order.ID, order.TotalSum);
        }
    }
}
class Product1 {
    int ID;
    String name;
    int cost;
}
//Задача 19
class Device {
    String brand;
    void turnOn() {
        System.out.println("Включил устройство");
    }
    void turnOff() {
        System.out.println("Выключил устройство");
    }
}
class Smartphone extends Device {
    void takePhoto() {
        System.out.println("Сделал фотогорафию");
    }
    void callfried(String name) {
        System.out.println("Звоню контакту " + name);
    }
}
class Laptop extends Device {
    void HackPentagon() {
        System.out.println("Взломал Пентагон");
    }
    void Programme() {
        System.out.println("Я устал клик клак по клавиатуре");
    }
}
//Задача 20
class Player1 {
    String name;
    String step;
}

class Game{
    private String[][] field;

    public Game(){
        field = new String[3][3];
    }

    public void hod(int x, int y, Player1 p){
        System.out.println("Игрок "+ p.name+" ставит "+p.step+" на точку "+x+" "+y);
        field[x][y] = p.step;
    }

    public void printField(){
        for(int i = 0; i<3;i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(field[i][j]);
            System.out.println();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        //Продолжение задачи 3
        Animal[] animals = new Animal[3];

        animals[0] = new Cat();
        animals[1] = new Cow();
        animals[2] = new Dog();
        for (Animal animal: animals) {
            animal.makeSound();
        }
    }
}