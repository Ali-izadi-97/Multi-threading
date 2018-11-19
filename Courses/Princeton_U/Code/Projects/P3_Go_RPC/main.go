package main

import (
	"fmt"
)

func RunWordCount() {
	serverAddr := "localhost:8888"
	server := WordCountServer{serverAddr}
	server.Listen()
	input1 := "hello I am good hello bye bye bye bye good night hello"
	input2 := "today is a nice day for a nice warm cup of coffee"
	input3 := "if this then true else if that then false else panic"
	wordCounts1, err1 := RequestWordCount(input1, serverAddr)
	wordCounts2, err2 := RequestWordCount(input2, serverAddr)
	wordCounts3, err3 := RequestWordCount(input3, serverAddr)
	checkError(err1)
	checkError(err2)
	checkError(err3)
	fmt.Printf("Result: %v\n", wordCounts1)
	fmt.Printf("Result: %v\n", wordCounts2)
	fmt.Printf("Result: %v\n", wordCounts3)
}

func RunCristian() {
	serverAddr := "localhost:9999"
	server := CristianServer{serverAddr}
	server.Listen()
	t, err := SyncTime(serverAddr)
	checkError(err)
	fmt.Printf("Synced time is: %v\n", t)
}

func main() {
	RunWordCount()
	RunCristian()
}
