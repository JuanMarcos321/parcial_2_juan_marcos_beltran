# Comprensión del diseño — Enunciado B
**Nombre:** Juan Marcos Beltran Moreno
**Fecha:** 19/10/2026

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Evidencia que entendiste el contrato
**antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Modelo` es una clase abstracta y no concreta? Menciona qué método
obliga a cada subclase a implementar y qué gana el sistema con eso.

> _Tu respuesta:_ Modelo es abstracta porque un modelo cualquiera no se puede entrenar por si solo porque lo que existe son modelos concretos como CNN, RNN o Regresion. Se usa el metodo entrenar(Dataset) que obliga a cada subclase a implementarlo con su propia logica y asi el sistema gana polimorfismo.

---

### 2. Composición vs. agregación
Explica la diferencia entre `Experimento ◆— Modelo` (composición) y
`Plataforma ◇— Experimento` (agregación). ¿Qué pasaría con el modelo si se
elimina el experimento? ¿Y con los experimentos si se elimina la plataforma?

> _Tu respuesta:_  si el experimento se elimina, el modelo tambien se elimina porque es composicion, entonces significa que el modelo PERTENECE al experimento. En cambio en la agregación los experimentos se crean de forma independiente y la plataforma solo guarda las referencias a ellos, entonces si se elimina la plataforma igual los experimentos siguen existiendo.

---

### 3. Asociación
En `Investigador — Experimento`, ¿quién es dueño de quién? ¿Por qué se modela
como N:M y no como composición?

> _Tu respuesta:_ son clases independientes que solo se conocen por referencia, entonces ninguna es dueña de ninguna, y se modela como N:M porque un investigador puede lanzar varios experimentos y un experimento puede tener varios investigadores colaborando, entonces no es composición porque eso implicaria que el experimento pertenece a un unico investigador y desaparece con el y eso no se ajusta al problema.

---

### 4. Dependencia
¿Por qué `Modelo` **depende** de `MetricaEvaluacion` en lugar de **tenerlo**
como atributo? ¿Qué ventaja tiene pasar el servicio como parámetro?

> _Tu respuesta:_ como Modelo solo necesita MetricaEvaluacion de forma puntual no tiene sentido guardarlo como atributo porque eso lo convertiria en una parte permanente del modelo. La ventaja es que al recibirlo como parametro hay menos acoplamiento que significa quye el modelo no es responsable de crear servicio.

---

### 5. Listas
En este proyecto se usan dos estructuras distintas:
- `int[] lossPorEpoca` en `Modelo`
- `ArrayList<Experimento>` en `Plataforma`

Explica por qué en cada caso se eligió esa estructura y no la otra.

> _Tu respuesta:_ int[] lossPorEpoca se eligio porque el numero de epocas es fijo y ya se conoce, por lo que un arreglo de tamaño definido es simple y eficiente en memoria. En cambio, ArrayList<Experimento> se eligio porque la cantidad de experimentos de una plataforma no se conoce desde antes y va creciendo con agregarExperimento() y el ArrayList se redimensiona solito.