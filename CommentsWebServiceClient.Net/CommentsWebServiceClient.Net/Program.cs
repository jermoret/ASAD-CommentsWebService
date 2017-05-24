using System;
using System.Linq;
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
            var user = new user();
            while (loop)
            {
                try
                {
                    Console.WriteLine();
                    Console.WriteLine("What do you want to do ? :");
                    Console.WriteLine(" 1: List comments");
                    Console.WriteLine(" 2: Add comment");
                    Console.WriteLine(" 3: Delete comment");
                    Console.WriteLine(" 4: Seed 10 comments");
                    Console.WriteLine(" 5: Delete all comments");
                    Console.WriteLine(" 6: List comments for subject");
                    Console.WriteLine(" 7: Change authentification");
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
                                var comments = service.getComments(user) ?? new comment[0];
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
                                var result = service.addComment(user, comment);
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
                                var result = service.deleteComment(user, comment);
                                Console.WriteLine($"Result : {result}");
                                break;
                            }
                            case 4:
                            {
                                for (var i = 0; i < 10; ++i)
                                {
                                    service.addComment(user, new comment
                                    {
                                        subject = Lorem.Sentence(1),
                                        pseudo = user.login,
                                        comment1 = Lorem.Sentence(10),
                                    });
                                }
                                break;
                            }
                            case 5:
                            {
                                var comments = service.getComments(user);
                                foreach (var comment in comments)
                                {
                                    service.deleteComment(user, comment);
                                }
                                Console.WriteLine("Done");
                                break;
                            }
                            case 6:
                            {
                                Console.Write("Subject : ");
                                var subject = Console.ReadLine();
                                Console.WriteLine();
                                var comments = service.getCommentsForSubject(user, subject) ?? new comment[0];
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
                            case 7:
                            {
                                Console.Write("login : ");
                                user.login = Console.ReadLine();
                                Console.Write("pass  : ");
                                user.pass = Console.ReadLine();
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
                catch (Exception e)
                {
                    Console.WriteLine($"Error : {e}");
                }
            }

        }
    }
}
