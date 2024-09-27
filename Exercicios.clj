; Partial - Exercicio 01
(defn soma [a b] (+ a b))
(def soma10 (partial soma 10))
(println (soma 8 4))

; Partial - Exercicio 02
(defn converter-temp [m s t] (* (+ t s) m))
(def kelvin-para-celsius(partial converter-temp 1.0 -273.15))
(println (kelvin-para-celsius 250.0))
(println (kelvin-para-celsius 359.0))
(def faranheit-para-celsius
  (partial converter-temp (/ 5 9) -32))
(println (faranheit-para-celsius 80.0))

; Partial - Exercicio 03
(defn calcular-preco [preco desconto]
  (* preco (- 1 desconto)))
(def desconto-10porcento (partial calcular-preco 0.10))
(println "Desconto: " (desconto-10porcento 200))

; Partial - Exercicio 04
(defn concatenar [c a b] (c a b))
(def saudacao (partial concatenar str))
(println (saudacao "Mayara" " Vieira"))

; Partial - Exercicio 05
(defn calculadora [f a b] (f a b))
(println "Soma:" (calculadora + 5 6))
(def subtracao (partial calculadora -))
(println "Subtração:" (subtracao 6 3))
(def multiplicacao (partial calculadora *))
(println "Multiplicação:" (multiplicacao 9 2))
(def divisao (partial calculadora /))
(println "Divisão:" (divisao 9 3))

; Curryng - Exercicio 01
(defn adicionar [x] (fn [y] (+ x y)))
(println ((adicionar 5) 11))
(def adicionar5 (adicionar 5))
(println (adicionar5 6))

; Curryng - Exercicio 08
(defn transformar-texto [texto]
  (fn [operacao]
    (case operacao
      "maiuscula" (clojure.string/upper-case texto)
      "inverte" (reverse texto))))
(println ((transformar-texto "clojure") "maiuscula"))
(println ((transformar-texto "clojure") "inverte"))

; Curryng Exercicio 10
(defn criar-relatorio [formato]
  (fn [conteudo]
    (cond
      (= formato "PDF") (str "Relatório em PDF: " conteudo)
      (= formato "HTML") (str "<html><body>Relatório: " conteudo "</body></html>")
      (= formato "CSV") (str "Relatório em CSV: " (clojure.string/join "," (map str conteudo)))
      :else "Formato de relatório desconhecido.")))
(def relatorio-pdf (criar-relatorio "PDF"))
(def relatorio-html (criar-relatorio "HTML"))
(def relatorio-csv (criar-relatorio "CSV"))
(println (relatorio-pdf "Dados do relatório"))  
(println (relatorio-html "Dados do relatório"))  
(println (relatorio-csv [1 2 3 4]))      