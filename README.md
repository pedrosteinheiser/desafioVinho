# desafioVinho
Descritivo desafio vinho.

O sistema foi dividido no padrão MVC.

Model está na pasta Entidades. As entidades utilizadas foram: Cliente, Vinho, ItemDoPedido e Pedido.

View está na pasta Tela. Foi utilizado o Java.swing.JFrame para as telas, que são: TelaLogin, TelaCadastroCliente, TelaCadastrarVinho, TelaCatalogoVinhos, TelaEditarVinho, TelaGerenciamentoVinho, TelaPedido.

Control está na pasta Controladores. Que são: ControladorCliente, ControladorVinho e ControladorPedido.

O Armazenamento é feito por meio de arquivos de texto .dat, onde as entidades implementam o Serializable permitindo assim a utilização dos métodos persist() e load().


O WorkFlow de Telas é:

TelaLogin: Nela é possível registrar um novo cliente e depois efetuar o login para adentrar na tela de catálogo de pedidos. Através da senha ‘admin’ é possível entrar na tela de CRUD de vinhos.

TelaCatalogoVinhos: Nela é possível adicionar os vinhos que são apresentados em uma JTable no carrinho. Ao clicar no botão de finalizar a compra, é aberto a TelaCarrinho.

TelaCarrinho: Nesta tela é possível visualizar os vinhos que foram adicionados no carrinho que são demonstrados através de uma JTable. É possível também a remoção dos vinhos do carrinho. Ao clicar no botão “Finalizar Compra” é aberta a telaPedido.

TelaPedido: Através dos vinhos presentes no carrinho é exibido na tela o Peso total, o valor total e a quantidade de vinhos. Após o usuário colocar no campo distãncia, quantos Km ele está de Joinville e clicar no botão ‘Calcular Frete’, o cálculo do frete é feito e exibido na tela, junto ao valor total do pedido. Ao clicar no botão ‘Finalizar Compra’ é criado um novo pedido e armazenado.

OBS: Todo o cálculo do frete está localizado na classe ControladorPedido.
