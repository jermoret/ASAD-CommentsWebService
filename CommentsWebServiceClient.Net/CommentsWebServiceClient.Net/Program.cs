using System;
using CommentsWebServiceClient.Net.CommentsService;
using Faker;

namespace CommentsWebServiceClient.Net
{
    class Program
    {
        static void Main(string[] args)
        {
            var service = new CommentsServiceClient();
            var loop = true;
            while (loop)
            {
                Console.WriteLine();
                Console.WriteLine("What do you want to do ? :");
                Console.WriteLine(" 1: List comments");
                Console.WriteLine(" 2: Add comment");
                Console.WriteLine(" 3: Delete comment");
                Console.WriteLine(" 4: Seed 10 comments");
                Console.WriteLine(" 5: Delete all comments");
                Console.WriteLine(" 6: List comments for subject");
                Console.WriteLine(" 0: End the program");
                Console.Write("Choice : ");
                byte choice;
                if (byte.TryParse(Console.ReadLine(), out choice))
                {
                    switch (choice)
                    {
                        case 0:
                            loop = false;
                            break;
                        case 1:
                        {
                            var comments = service.getComments();
                            foreach (var comment in comments)
                            {
                                Console.WriteLine($"subject  : {comment.subject}");
                                Console.WriteLine($"pseudo   : {comment.pseudo}");
                                Console.WriteLine($"comment  : {comment.comment1}");
                                Console.WriteLine();
                            }
                            Console.WriteLine($"Total number : {comments.Length}");
                            Console.WriteLine();
                                break;
                        }
                        case 2:
                        {
                            var comment = new comment();
                            Console.Write("subject : ");
                            comment.subject = Console.ReadLine();
                            Console.Write("pseudo  : ");
                            comment.pseudo = Console.ReadLine();
                            Console.Write("comment : ");
                            comment.comment1 = Console.ReadLine();
                            var result = service.addComment(comment);
                            Console.WriteLine($"Result : {result}");
                            break;
                        }
                        case 3:
                        {
                            var comment = new comment();
                            Console.Write("subject : ");
                            comment.subject = Console.ReadLine();
                            Console.Write("pseudo  : ");
                            comment.pseudo = Console.ReadLine();
                            Console.Write("comment : ");
                            comment.comment1 = Console.ReadLine();
                            var result = service.deleteComment(comment);
                            Console.WriteLine($"Result : {result}");
                            break;
                        }
                        case 4:
                        {
                            for (var i = 0; i < 10; ++i)
                            {
                                service.addComment(new comment
                                {
                                    subject = Lorem.Sentence(1),
                                    pseudo = Lorem.Sentence(1),
                                    comment1 = Lorem.Sentence(10),
                                });
                            }
                            break;
                        }
                        case 5:
                        {
                            var comments = service.getComments();
                            foreach (var comment in comments)
                            {
                                service.deleteComment(comment);
                            }
                            Console.WriteLine("Done");
                            break;
                        }
                        case 6:
                        {
                            Console.Write("Subject : ");
                            var subject = Console.ReadLine();
                            Console.WriteLine();
                            var comments = service.getCommentsForSubject(subject);
                            foreach (var comment in comments)
                            {
                                Console.WriteLine($"subject  : {comment.subject}");
                                Console.WriteLine($"pseudo   : {comment.pseudo}");
                                Console.WriteLine($"comment  : {comment.comment1}");
                                Console.WriteLine();
                            }
                            Console.WriteLine($"Total number : {comments.Length}");
                            Console.WriteLine();
                            break;
                        }
                        default:
                            Console.WriteLine("Invalid choice !");
                            break;
                    }
                }
                else
                {
                    Console.WriteLine("Invalid choice !");
                }
            }

        }
    }
}
