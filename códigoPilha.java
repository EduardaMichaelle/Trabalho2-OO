//CLASSE PILHA
class Pilha {
    private static int TAM_MAX = 1000; 
    private int valores[];
    private int topo;

    //CONSTRUTOR
    public Pilha() {
        valores = new int[TAM_MAX]; //NOVO VETOR DE INTEIROS COM O TAMANHO MÁXIMO DEFINIDO
        topo = -1; //VALOR INICIAL DO TOPO DEFINIDO COMO -1
    }

    public int getTopo() {
        return this.topo;
    }

    public int[] getValores() {
        return this.valores;
    }

    //MÉTODO EMPTY 
    public boolean empty() {
        return topo == -1; //SE O TOPO FOR IGUAL A -1 O MÉTODO RETORNARÁ "TRUE"
    }
    
    //MÉTODO PUSH
    public void push(int valor) { //O MÉTODO PUSH RECEBE UM VALOR COMO PARÂMETRO 
        if (topo == TAM_MAX - 1) { //SE O VALOR DO TOPO FOR IGUAL AO TAM_MAX = PILHA CHEIA
            throw new IllegalStateException("A pilha está cheia. Não é possível adicionar mais elementos."); //UMA EXCEÇÃO PARA IMPRIMIR UMA MENSAGEM
        } 
        valores[++topo] = valor; //CASO A PILHA NÃO ESTEJA CHEIA, UM NÚMERO É EADICIONADO AO TOPO DELA
    }
    
    //PRIMEIRA VARIAÇÃO DO MÉTODO PUSH 
    public void pushArray(int[] novosValores) { //O MÉTODO pushArray RECEBE UM ARRAY DE VALORES COMO PARÂMETRO 
        for (int valor : novosValores) { //FOR PARA PERCORRER CADA VALOR DO VETOR novosValores
            push(valor); //CHAMAMOS O MÉTODO PUSH ORIGINAL PARA EMPILHAR CADA VALOR INDIVIDUALMENTE 
        }
    }
    
    //SEGUNDA VARIAÇÃO DO MÉTODO PUSH
    public void pushPilha(Pilha outraPilha) { //O MÉTODO pushPilha RECEBE UMA PILHA outraPilha COMO PARÂMETRO
        int outrosValores[] = outraPilha.getValores(); //OBTENDO OS VALORES DA outraPilha COM O MÉTODO getValores E INSERINDO NUM NOVO VETOR outrosValores
        for (int i = 0; i <= outraPilha.getTopo(); i++) { //FOR PARA PASSAR PELOS VALRORES DA outraPilha  
            push(outrosValores[i]); //USANDO O MÉTODO PUSH DA PILHA ATUAL PARA INSERIR OS VALORES DA outraPilha 
        }
    }
    
    //MÉTODO POP
     public int pop(){
        if (empty()){ //SE A PILHA ESTIVER VAZIA
            throw new IllegalStateException("A pilha está vazia. Não é possível remover elementos."); //UMA MENSAGEM DE EXCEÇÃO SERÁ IMPRESSA
        }
        
        int valorRemovido = valores[topo]; //ARMAZENANDO O VALOR DO TOPO DA PILHA NA VARIÁVEL valorRemovido
        topo--; //ATUALIZANDO O VALOR DO TOPO, AGORA TERÁ UM VALOR A MENOS
        return valorRemovido; //RETORNANDO O VALOR QUE FOI REMOVIDO DO TOPO DA PILHA
    }
    
    //VARIAÇÃO DO MÉTODO POP 
    public void pops(int quantidade) {
        if (empty()) {
            return; // Se a pilha estiver vazia, não há elementos para desempilhar
        }
        
        if (quantidade >= topo + 1) { //SE A QUANTIDADE DE NÚMEROS REQUERIDOS PARA SEREM RETIRADOS DA PILHA FOR MAIOR QUE A QUANTIDADE MÁXIMA DA PILHA
            topo = -1; // REMOVE TODOS OS ELEMENTOS DA PILHA, REINICIALIZANDO O TOPO
        } else { //CASO CONTRÁRIO
            topo = topo - quantidade; // DESEMPILHA A QUANTIDADE ESPECIFICADA
        }
    }
    
    //MÉTODO TOP
    public int top(){
        if(empty()){ 
            throw new IllegalStateException("A pilha está vazia. Não é possível remover elementos.");
        }
        
        return valores[topo]; //RETORNANDO O VALOR QUE ESTÁ NO TOPO DA PILHA
    }
}

//MAIN
public class Principal{
	public static void main(String[] args) {
	 
        Pilha pilha = new Pilha(); //CRIANDO UM OBJETO DO TIPO PILHA
        
        pilha.pushArray(new int[]{10, 20, 30}); 
        
        pilha.pops(2); 
        
        int topoResultante = pilha.top();
        System.out.println("Topo resultante: " + topoResultante);
        
	}
}
