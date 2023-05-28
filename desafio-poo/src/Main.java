import br.com.fourtk.desafio.dominio.Bootcamp;
import br.com.fourtk.desafio.dominio.Curso;
import br.com.fourtk.desafio.dominio.Dev;
import br.com.fourtk.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);


        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev jean = new Dev();
        jean.setNome("Jean Santos");
        jean.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Jean:" + jean.getConteudosInscritos());
        jean.progredir();
        jean.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Jean:" + jean.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Jean:" + jean.getConteudosConcluidos());
        System.out.println("XP:" + jean.calcularTotalXp());

        System.out.println("-------");

        Dev melissa = new Dev();
        melissa.setNome("melissa");
        melissa.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Melissa:" + melissa.getConteudosInscritos());
        melissa.progredir();
        melissa.progredir();
        melissa.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Melissa:" + melissa.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Melissa:" + melissa.getConteudosConcluidos());
        System.out.println("XP:" + melissa.calcularTotalXp());
        
    }
}
