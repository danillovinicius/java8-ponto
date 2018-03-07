# java8-ponto
exemplo java8 para calculo de horas de entrada e saida no ponto;

localhost:8080/api/v1/ponto/incluir-registro

```json
{
	"data":"2018-03-07",
	"horario":"13:03"
} 
```

localhost:8080/api/v1/ponto/incluir-lista

```json
[
	{
		"data":"2018-03-07",
		"horario":"18:10"
	},
	{
		"data":"2018-03-07",
		"horario":"12:03"
	},
	{
		"data":"2018-03-07",
		"horario":"08:02"
	},
	{
		"data":"2018-03-07",
		"horario":"13:02"
	}
]
```

localhost:8080/api/v1/ponto/listar

localhost:8080/api/v1/ponto/remove/dia/

```json
{
	"data":"2018-03-07"
}
```

localhost:8080/api/v1/ponto/go-home

```json
{
	"data":"2018-03-07"
}
```