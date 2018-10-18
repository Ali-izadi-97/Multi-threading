package main

import (
	"net/rpc"
	"strings"
)

type WordCountServer struct {
	addr string
}

type WordCountRequest struct {
	Input string
}

type WordCountReply struct {
	Counts map[string]int
}

func (server *WordCountServer) Listen() {
	rpc.Register(server)
	startListener(server.addr)
}

func (*WordCountServer) Compute(request WordCountRequest, reply *WordCountReply) error {
	counts := make(map[string]int)
	input := request.Input
	tokens := strings.Fields(input)
	for _, t := range tokens {
		counts[t] += 1
	}
	reply.Counts = counts
	return nil
}

func RequestWordCount(input string, serverAddr string) (map[string]int, error) {
	client, err := rpc.Dial("tcp", serverAddr)
	checkError(err)
	args := WordCountRequest{input}
	reply := WordCountReply{make(map[string]int)}
	err = client.Call("WordCountServer.Compute", args, &reply)
	if err != nil {
		return nil, err
	}
	return reply.Counts, nil
}
