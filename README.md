**ENGLISH VERSION BELOW!**
***
**Fundação Edson Queiroz** <br>
**Universidade de Fortaleza** <br>
**Centro de Ciências Tecnológicas** <br>
**Disciplina: Fundamentos de Bancos de Dados** <br>
<br>
Esta é uma aplicação desenvolvida como projeto para a disciplina de Fundamentos de Bancos de Dados. Abaixo encontram-se os requisitos dados pelo professor Luciano Leal Do Vale.

### DESENVOLVIMENTO DE UMA APLICAÇÃO EM BANCOS DE DADOS

#### 1. INTRODUÇÃO
Neste trabalho, devem ser apresentados todos os passos necessários para o desenvolvimento de uma aplicação cliente/servidor, utilizando um banco de dados relacional, em uma arquitetura de duas camadas na web.

#### 2. O PROBLEMA
Um grupo de investidores decidiu comprar parte das ações de uma pequena e inovadora empresa, a NEW Tecnologia em Informática S.A.. Agora, com o aporte financeiro de seus novos sócios, a NEW pretende desenvolver um revolucionário ambiente virtual de ensino a distância (e-learning). A primeira parte deste ambicioso projeto consiste em um sistema virtual de avaliação simulada. Neste ambiente, os alunos associados, mediante pagamentoAlunos trimestrais, poderão obter provas simuladas versando sobre diferentes temas. A correção destas avaliações simuladas poderá ser feita tanto de forma on-line como também por um facilitador-avaliador do site, o qual deverá ser um profissional renomado na área em questão. O grupo necessita controlar e gerenciar todas as tarefas referentes ao funcionamento do site, as quais vão desde publicidade, inscrição de alunos, pagamentoAluno dos facilitadores-avaliadores, além do acompanhamento e avaliação do rendimento dos alunos. Adicionalmente, é de extrema importante para os executivos da NEW consultar as informações envolvidas nestes processos, a fim de avaliar o comportamento da organização bem como definir as estratégias e políticas globais da companhia.

+ ##### O projeto dessa aplicação atenderá às seguintes funcionalidades básicas:
  - Cadastros: alunos, facilitadores, matérias, assuntos, perguntas e opções de resposta.
  - Registro das inscrições dos alunos associados e controle dos pagamentoAlunos efetuados;
  - Registro dos pagamentoAlunos efetuados aos avaliadores;
  - Avaliação continuada do aproveitamento dos participantes (controle das notas obtidas nos simulados);
  - Permitir a pesquisa de participantes através dos seguintes “filtros”: matrícula, nome, temas dos simulados que realizou, aproveitamento nos simulados;
  - Permitir a pesquisa de facilitadores através dos seguintes “filtros”: matrícula, nome, matérias em que está apto a atuar, número de simulados que avaliou;

+ ##### NB:
  1. O cadastro de um determinado item compreende as operações de inclusão, exclusão e alteração.
  2. As consultas devem ser geradas dinamicamente a partir dos “filtros” escolhidos pelo usuário.
  3. Uma vez matriculado o aluno pode utilizar os serviços do site por três meses.Após este período o aluno deverá renovar        sua matrícula por igual período de tempo. Durante a matrícula, o aluno deverá indicar as matérias (disciplinas) em que        tem interesse. O valor da inscrição, o qual deverá ser pago pelo aluno, será calculado a partir do número de disciplinas      e do valor de cada disciplina. Cada disciplina pode ter um valor diferente. O valor da matrícula corresponde a soma dos      valores das disciplinas escolhidas pelo aluno.
  4. Cada facilitador está habilitado a atuar em um determinado grupo de matérias (disciplinas).
  5. Cada matéria tem diversos assuntos. Para cada assunto existe um conjunto de perguntas associadas a ele. Uma pergunta pode ter resposta objetiva ou subjetiva. Cada pergunta objetiva deve ter um conjunto de opções onde somente uma será a correta.
  6. Quando um aluno pede para realizar um teste simulado, o sistema deverá escolher aleatoriamente um conjunto de questões relativas a matéria (ou matéria e assunto) indicada pelo estudante, as quais deverão ser visualizadas pelo aluno ou disponibilizadas para download (fica a critério do aluno associado). Além disso, o aluno pode indicar também se deseja apenas questões objetivas, apenas subjetivas ou ambas. Caso o teste simulado seja constituído apenas por questões objetivas a correção do mesmo deverá ser feita de forma on-line. Caso contrário as respostas do aluno deverão ser encaminhadas a um facilitador-avaliador. O qual procederá a avaliação do teste.
  7. Deve-se armazenar também as notas que os alunos obtiveram nos diversos simulados.
  8. O site deve apresentar também um ranking dos alunos que obtiveram os melhores resultados nos testes a que se submeteram.
  9. A cada inscrição ou renovação o aluno ganha um bônus no valor de 10% do valor de sua inscrição. O bônus, que pode ser acumulado, pode ser utilizado na compra de produtos ofertados pelo site: como livros, CD’s, camisetas, etc.
  10. Um estudante associado poderá enviar dúvidas, as quais serão automaticamente alocadas a um facilitador habilitado no tema. O facilitador deverá responder a pergunta via e-mail.
  11. O pagamentoAluno dos facilitadores deverá ser feito com base nos simulados e dúvidas alocadas a ele. O valor a ser pago por cada simulado e por cada dúvida deve estar em uma tabela de parâmetros.

#### 3. ORIENTAÇÕES GERAIS
- O programa proposto neste trabalho deverá ser desenvolvido obrigatoriamente em uma das seguintes linguagens: C/C++ (para estudantes de Engenharia) ou Java (para estudantes de Ciência da Computação ou ADS);
- Devem ser usados comando SQL Padrão. Não será permitido uso de frameworks que gerem os comandos como por exemplo: Hibernate.
- Dúvidas acerca dos requisitos do programa deverão ser esclarecidas com o professor;
- O código fonte do programa deverá ser enviado através do Unifor Online até a data estipulada para a entrega do trabalho;
- O trabalho deverá ser demonstrado pela execução do mesmo, quando será verificado se a especificação foi atendida. O aluno poderá ser arguido a fim de demonstrar que realmente domina os conceitos de programação orientada a objetos, bem como o código desenvolvido;
- Serão considerados, na avaliação do trabalho, a execução correta do programa (atendimento aos requisitos) e a conformidade do código fonte ao conteúdo abordado na disciplina;
- Qualquer tentativa de cópia do trabalho de outro aluno ou da Internet, ou qualquer outra tentativa de fraudar o trabalho, incluindo cópia de trechos do programa, resultará e aplicação de nota ZERO.

#### 4. ATIVIDADES
  4.1. Elabore um diagrama de entidades e relacionamentos (DER) para o problema apresentado.
  
  4.2. Faça o mapeamento do seu esquema (diagrama) para o modelo relacional.
    - Indicar as chaves primárias, estrangeiras e outras chaves utilizadas.
    - Indicar o tipo e o tamanho dos atributos.
    - Indicar se o atributo é ou não “NOT NULL”
    __OBS__ : Nesta etapa pode ser utilizada uma ferramenta case, como por exemplo o ErWin.

  4.3. Implemente o seu esquema relacional em um SGBD relacional.
  
  4.4. Crie as seguintes visões:
    - Crie uma visão que mostre para cada aluno: o seu nome e o valor total pago por ele.
    - Crie uma visão que mostre para cada matéria e assunto a sua descrição e o total de questões disponíveis.
    - Crie uma visão que mostre para cada facilitador seu nome e o número de matérias em que está apto a atuar.

  4.5. Crie um trigger para a seguinte tarefa:
    - Ao inserir, atualizar, ou remover uma inscrição o bônus do aluno deve ser atualizado.
    - Ao se cadastrar um novo teste simulado (contendo questões subjetivas) um facilitador habilitado na matéria referente ao teste deve ser escolhido automaticamente. Além disso, a empresa deseja que os facilitadores fiquem com cargas de trabalho semelhantes.
    - Ao se cadastrar uma dúvida de um aluno esta deverá ser alocada a um facilitador habilitado.

  4.6. Crie stored procedures para as seguintes tarefas:
    - Crie uma stored procedure que calcule o valor a ser pago para pelos serviços prestados por um determinado facilitador em um determinado período. Considere como parâmetros de entrada: o código do facilitador, e data inicial e final (período) das atividades do facilitador que deverão ser consideradas no cálculo. O procedimento deverá também inserir uma tupla referente a este pagamentoAluno na tabela de “pagamentoAlunos”.
    - Crie um stored procedure que receba como parâmetro de entrada um número inteiro “n” e calcule o ranking dos “n” melhores alunos, considerando todos os simulados realizados. O procedimento deverá guardar esta informação em uma tabela a fim de ser utilizada no site, ou seja, ou site irá mostrar os “n”melhores alunos gerados pelo último “ranking” realizado.
    NB: Você pode criar visões, triggers e stored procedures para facilitar a implementação do seu projeto.

#### 5. CRITÉRIOS DE AVALIAÇÃO
##### A avaliação do trabalho irá envolver os seguintes quesitos:
   - Funcionalidade
  - Documentação
  - Padronização
  - Modularidade
  - Flexibilidade
  - Projeto do Banco de Dados
  - Interface Gráfica
  - Tratamento de Eventos
  - Tratamento de Exceção
  - Clareza de Código


***

**Edson Queiroz Foundation** <br>
**University of Fortaleza** <br>
**College of Technological Sciences** <br>
**Course: Database Fundamentals** <br>
<br>
This is an application developed as a project for the Database Fundamentals course. Below you can find the requirements written by professor Luciano Leal do Vale.

### DEVELOPMENT OF A DATABASE APPLICATION

#### 1. INTRO
In this assignment, you must demonstrate every step necessary in order to develop a client/server application by using a relational database in a two-tier web architecture.

#### 2. THE PROBLEM

A group of investors decided to buy stock in a small and innovative company, NEW Technology Computing Inc. Now, with the financial input of their new partners, NEW wants to develop a revolutionary virtual e-learning environment. The first part of this ambitious project consists in a virtual exam evaluating system. In this environment, the associated students, via quarterly payments, may obtain exams about different subjects. The exams can be graded both online or by an instructor from the website, of whom must be a well renowned professional in the exam’s area of study. The group needs to control and manage all the tasks referring to the operation of the website, of which includes publicity, student subscription, instructors payrolls, and monitoring and evaluating each student’s results. Additionally, it is extremely important for the executives of NEW to consult the information involved in these processes in order to evaluate the behavior of the organization as well as defining the strategies and global policies of the company.

+ ##### The project of this application must have the following basic functionalities:
  - Registrations: students, instructors, courses, subjects, questions and answers (alunos, facilitadores, matérias, assuntos, perguntas and opções de resposta);
  - Registries of associated students subscriptions and control over students payments;
  - Registries of the instructors payroll;
  - Continuous evaluation of each participant (control of grades obtained on each exam);
  - Allowing the search of participants by using the following “filters”: ID, name, subjects of each exam taken, GPA;
  - Allowing the search of instructors by using the following “filters”: ID, name, courses he is allowed to teach, number of graded exams.
  
+ ##### NB:
  1. Registering a certain item includes the operations of INSERT, DELETE and UPDATE.
  2. The queries must be generated dynamically by one of the “filters” chosen by the user.
  3. Once registered, the student can utilize the website’s services for three months. After that, the student must renew his or her registration for another three months. On the registration process, the student must indicate the courses he is interested in. The subscription value, of which should be pay by the student, will be calculated by the amount of courses and each course’s cost. Each course may have a different value. The registration fee equals the sum of values of each course chosen by the student.
  4. Each instructor is allowed to act in a certain group of courses.
  5. Each course has various subjects. For each subject there is a set of questions associated to it. A question may have a multiple-choice or an open-ended answer. Each multiple-choice question must have one set of options of which only one is the correct answer.
  6. When a student asks to take an exam, the system must randomly choose a set of questions related to the course (or course and subject) selected by the student, of which must be visualized by the student or be available to download (it is up to the associated student). Also, the student may indicate as well if he wants multiple-choice questions only, open-ended questions only or if he wants both. If the exam only has multiple-choice answers, it will be graded online. Otherwise, the student’s answers must be delivered to an instructor who will grade the exam.
  7. It is also necessary to keep every grade a student got in his exams.
  8. The website must also have a ranking of the students who had the best results in the exams they took
  9. On each subscription or renovation, the student receives a bonus of 10% his subscription fee. The bonus, which can be accumulated, may be used in the purchase of products for sale on the website such as books, CDs, T-shirts, etc.
  10. A registered student may send messages asking questions about the material, which will be automatically allocated to a qualified instructor. The instructor must answer the question via email.
  11. Paying an instructor must be made based on exams and student questions allocated to him/her. The amount to be paid for each exam and each question must be in a parameter table.

#### 3. ORIENTATIONS
- The software proposed in this assignment must be developed in one of the following languages: C/C++ (for computer engineering students) or Java (for computer science students);
- You must use SQL standard commands. The use of frameworks that generate the commands such as Hibernate will not be allowed;
- Any questions about the software’s requirements must be asked directly to the professor;
- The source code of the software must be sent via Unifor Online before the deadline;
- In order to grade the assignment and verify if it meets the requirements, a demo time will be scheduled. The student may be quizzed in order to demonstrate that he truly mastered the concepts of OOP, as of the code developed;
- It will be considered during the evaluation the proper execution of the software (requirements meeting) and the conformity of the source code to the material previously seen on this course;
- Any copy attempts from another student or from the internet, as for any other forms of fraud, including copying parts of the software will result in an F.

#### 4. ACTIVITIES
  4.1. Make an entity-relationship diagram for the presented problem.

4.2. Map your schema by following the relational model.
  - Indicate the primary keys, foreign keys and other keys that you may have inserted.
  - Point out whether the attribute is or isn’t “NOT NULL” PS This step allows you to use a tool e.g. ErWin.

  4.3. Implement your relational schema in a relational DBMS.

  4.4. Create the following visions:
   - Create a vision that shows to each student: their names and amount of money paid by them.
   - Create a vision that shows to each course and subject its description and the amount of questions available.
   - Create a vision that shows to each instructor their name and number of courses they are able to teach.

  4.5. Create a trigger for the following task:
   - By inserting, updating or removing a subscription the student’s bonus must be updated.
   - By registering a new exam, an instructor able to teach the course the exam belongs to, must be chosen automatically. Besides, the company wishes that the instructors have similar work hours.
   - By registering a student’s question, it must be allocated to a qualified instructor.

  4.6. Create stored procedures for the following tasks:
    - Create a stored procedure that will calculate the amount to be paid for an instructor’s services during a certain period. Consider as IN parameters: the instructor’s ID, and starting and finishing dates of  his work which should be taken into account in the calculation. The procedure must also insert a tuple for this pagamentoAluno (paymentStudent) in the pagamentoAlunos (paymentStudents) table.
    - Create a stored procedure that receives as an IN parameter an integer “n” and calculates the top “n” best students, considering all the exams taken. The procedure must keep this information inside a table in order to be used on the website. In other words, the website will show the top “n” best students generated by the last “ranking”. NB: You can create visions, triggers and stored procedures in order to facilitate the implementation of your project.

#### 5. EVALUATION CRITERIA
##### This assignment will be evaluated according to the following requirements:
  - Functionality
  - Documentation 
  - Standardization
  - Modularity 
  - Flexibility
  - Database design
  - Graphic user interface
  - Event handling
  - Exception handling
  - Code clarity
  
