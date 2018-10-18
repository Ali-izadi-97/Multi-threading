package main

import (
	"log"
	"net"
	"net/rpc"
)

func checkError(err error) {
	if err != nil {
		log.Fatal(err)
	}
}

func startListener(serverAddr string) {
	l, err := net.Listen("tcp", serverAddr)
	checkError(err)
	go func() {
		for {
			rpc.Accept(l)
		}
	}()
}
