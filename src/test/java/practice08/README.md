写一个Person类，要有id，name，age属性，靠id来判断是否是同一个人。要有一个introduce方法，
introduce方法返回一个字符串形如：

>My name is Tom. I am 21 years old.

再写一个Student类继承Person类，除了id，name，age属性，还有要有Klass属性。也有一个introduce方法，
introduce方法返回一个字符串形如：

>My name is Tom. I am 21 years old. I am a Student. I am at Class 2.

但是Student的Klass属性不是一个数字，而是一个对象，写一个Klass类，有number属性还有一个leader属性。但是leader属性不在构造器里。

Student构造的时候把Klass的一个实例传给Student，参见测试用例。
Klass有一个assignLeader方法，接收一个Student实例。意为将一名学生设置为该Klass的班长。
如果Klass的Leader是Tom，那么Tom调用introduce的方法就要返回：

>My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.

如果没有就继续返回旧的字符串。
~~~~
再写一个Teacher类继承Person类，除了id，name，age属性，也有Klass属性。也有一个introduce方法，
introduce方法返回一个字符串形如：

>My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2.

如果Klass为空，就会返回：

>My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.

所有Person的子类的这段文字：

>My name is Tom. I am 21 years old.

都应该调用Person的introduce方法来获得。