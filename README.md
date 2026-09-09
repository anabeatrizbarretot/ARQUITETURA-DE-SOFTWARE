# Sistema de Comércio Eletrônico - Cálculo de Frete

Este repositório contém a resolução da **Atividade 04: Inversão de Dependência (DIP)** para a disciplina de Arquitetura de Software. O objetivo principal foi refatorar um módulo de comércio eletrônico em Java para desacoplar a classe de localização/endereço das implementações concretas das empresas de transporte.

---

## 🎯 Objetivo da Atividade

Modificar o projeto do sistema de comércio eletrônico para **inverter a dependência** entre a classe de endereço (`Location`) e a empresa de transporte (`DeliveryCompany`), aplicando um dos princípios fundamentais do SOLID: o **Dependency Inversion Principle (DIP)**.

### Princípio da Inversão de Dependência (DIP)
* Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações.
* Abstrações não devem depender de detalhes. Detalhes devem depender de abstrações.

---

## 🛠️ O que foi Refatorado?

* **Criação da Abstração:** Foi introduzida a interface `DeliveryCompany`, definindo o contrato para o cálculo de frete.
* **Desacoplamento da Classe `Location`:** A classe `Location` deixou de instanciar ou depender diretamente de uma transportadora específica (como `CorreiosDeliveryService`). Agora ela recebe qualquer objeto que implemente a interface `DeliveryCompany` via injeção de dependência no método de cálculo.
* **Implementação Concreta:** A classe `CorreiosDeliveryService` foi adaptada para assinar o contrato da interface `DeliveryCompany`.

---

## 📦 Estrutura do Projeto

O código está consolidado no arquivo `EcommerceShipping.java` e é composto pelas seguintes estruturas:

* **Domínio de Produtos/Carrinho:** `Photo`, `Item`, `ItemItems`, `ShoppingCart`
* **Domínio de Frete:** `ShippingCost`, `Location`
* **Abstração (DIP):** `DeliveryCompany` *(Interface)*
* **Serviço Concreto:** `CorreiosDeliveryService`
* **Classe Principal (Execução):** `EcommerceShipping`

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
* **Java Development Kit (JDK)** versão 11 ou superior instalada.
* **Git** instalado.
* Editor de código (VS Code).

### Passo a passo

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/anabeatrizbarretot/ARQUITETURA-DE-SOFTWARE.git](https://github.com/anabeatrizbarretot/ARQUITETURA-DE-SOFTWARE.git)
